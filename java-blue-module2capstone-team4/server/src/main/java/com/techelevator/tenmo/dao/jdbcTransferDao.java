package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcTransferDao implements TransferDao{
    private JdbcTemplate jdbcTemplate;
    private  AccountDao accountDao;
    private TransferDao transferDao;

    public jdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
    }


    @Override
    public Transfer send(Transfer transfer) {

        int id = 0;

        Transfer newTransfer = null;

        // 0. Check to see if a transfer can be made at all?
        BigDecimal sendingAccount = accountDao.getBalance(transfer.getAccountFrom());
        BigDecimal receivingAccount = accountDao.getBalance(transfer.getAccountTo());

        if (sendingAccount.compareTo(transfer.getAmount()) == 1 &&
                transfer.getAmount().compareTo(BigDecimal.ZERO) == 1 &&
                transfer.getAccountFrom() != (transfer.getAccountTo())) {
            sendingAccount.subtract(transfer.getAmount());
            receivingAccount.add(transfer.getAmount());

            // 1. insert into the transfer table
            String sql = "insert into transfer( account_from, account_to, amount , status, account_id, date) " +
                    " values(?, ?, ?, ?, ?, ? ) RETURNING transfer_id";
            try {
                int transferId = jdbcTemplate.queryForObject(sql, int.class, transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount(), transfer.getStatus(), transfer.getAccountFrom(), transfer.date());
                //will likely want to set the transferId in the transfer Object, using the setter.
                transfer.setTransferId(transferId);
                newTransfer = getTransferById(transferId);
            } catch (CannotGetJdbcConnectionException e) {
                System.out.println("Can't connect to server or database");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // 2. increase the balance of the recipient

            String sql2 = "update account set balance = balance + ? where account_id = ?;";
            jdbcTemplate.update(sql2, transfer.getAmount(), transfer.getAccountTo());

            // 3. decrease the balance of the sender
            String sql3 = "update account set balance = balance - ? where account_id = ?;";
            jdbcTemplate.update(sql3, transfer.getAmount(), transfer.getAccountFrom());

        } else {
            transfer.setStatus("rejected");
        }
        return newTransfer;
    }

    @Override
    public List<Transfer> myTransfers(int userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfer WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }

    @Override
    public List<Transfer> allTransfers() {
        List<Transfer> transfersList = new ArrayList<>();
        String sql = "SELECT * FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfersList.add(transfer);
        }
        return transfersList;
    }

    @Override
    public Transfer getTransferById(int id) {
        String sql = "SELECT * FROM transfer WHERE transfer_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        Transfer transfer = null;

        if(rowSet.next()) {
            transfer = mapRowToTransfer(rowSet);
        }
        return transfer;
    }

    public Transfer mapRowToTransfer(SqlRowSet rowSet) {
        Transfer transfer = new Transfer();
       transfer.setTransferId(rowSet.getInt("transfer_id"));
       transfer.setAccountFrom(rowSet.getInt("account_from"));
        transfer.setAccountTo(rowSet.getInt("account_to"));
       transfer.setDate(rowSet.getDate("date").toLocalDate());
       transfer.setStatus(rowSet.getString("status"));
       transfer.setAmount(rowSet.getBigDecimal("amount"));

        return  transfer;
    }
}
