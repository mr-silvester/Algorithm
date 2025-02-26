SELECT 
    COUNT(*) 
FROM 
    USER_INFO U 
WHERE 
    YEAR(U.JOINED) = 2021 
    AND U.AGE IS NOT NULL 
    AND U.AGE BETWEEN 20 AND 29;