SELECT 
    SUB.USER_ID,
    SUB.PRODUCT_ID
FROM (SELECT 
    O.USER_ID,
    O.PRODUCT_ID,
    COUNT(*) AS CNT 
FROM 
    ONLINE_SALE O 
GROUP BY 
    O.USER_ID,
    O.PRODUCT_ID
HAVING 
    CNT >= 2) SUB 
ORDER BY 
    SUB.USER_ID ASC,
    SUB.PRODUCT_ID DESC