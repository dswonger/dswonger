package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import javax.xml.crypto.dsig.TransformService;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {
    Transfer send(Transfer transfer);



    List<Transfer> myTransfers(int userId);

    List<Transfer> allTransfers();

    Transfer getTransferById(int id);
}
