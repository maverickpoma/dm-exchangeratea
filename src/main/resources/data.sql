CREATE TABLE CURRENCY (
                          currency_id BIGINT NOT NULL AUTO_INCREMENT,
                          code VARCHAR(255),
                          PRIMARY KEY (currency_id)
);

CREATE TABLE EXCHANGE_RATE (
                               EXCHANGE_RATE_ID BIGINT PRIMARY KEY,
                               RATE DECIMAL(18, 2) NOT NULL,
                               SOURCE_CURRENCY_CURRENCY_ID BIGINT NOT NULL,
                               TARGET_CURRENCY_CURRENCY_ID BIGINT NOT NULL,
                               FOREIGN KEY (SOURCE_CURRENCY_CURRENCY_ID) REFERENCES CURRENCY (CURRENCY_ID),
                               FOREIGN KEY (TARGET_CURRENCY_CURRENCY_ID) REFERENCES CURRENCY (CURRENCY_ID)
);

INSERT INTO CURRENCY (CURRENCY_ID, CODE) VALUES (1, 'USD'),(2, 'EUR'),(3, 'JPY'),(4, 'GBP');


INSERT INTO EXCHANGE_RATE (RATE, EXCHANGE_RATE_ID, SOURCE_CURRENCY_CURRENCY_ID, TARGET_CURRENCY_CURRENCY_ID)
VALUES
    (0.89, 1, 1, 2),      -- USD to EUR
    (110.50, 2, 1, 3),    -- USD to JPY
    (0.72, 3, 1, 4),      -- USD to GBP
    (1.12, 4, 2, 1),      -- EUR to USD
    (125.304, 5, 2, 3),   -- EUR to JPY
    (0.89, 6, 2, 4),      -- EUR to GBP
    (0.0090, 7, 3, 1),    -- JPY to USD
    (0.0079, 8, 3, 2),    -- JPY to EUR
    (0.0064, 9, 3, 4),    -- JPY to GBP
    (1.39, 10, 4, 1),     -- GBP to USD
    (141.73, 11, 4, 2),   -- GBP to EUR
    (157.18, 12, 4, 3);   -- GBP to JPY