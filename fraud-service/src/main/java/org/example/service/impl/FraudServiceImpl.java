package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.FraudCheckHistory;
import org.example.repo.FraudCheckHistoryRepository;
import org.example.service.FraudService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdDate(LocalDateTime.now())
                        .build()
        );

        return fraudCheckHistory.getIsFraudster();
    }
}
