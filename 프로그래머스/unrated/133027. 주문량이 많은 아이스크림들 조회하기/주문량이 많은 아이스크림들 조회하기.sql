SELECT 
    FH.FLAVOR
FROM    
    FIRST_HALF AS FH
JOIN
    JULY
ON
    FH.FLAVOR=JULY.FLAVOR
GROUP BY
    FH.FLAVOR
ORDER BY
    SUM(FH.TOTAL_ORDER)+SUM(JULY.TOTAL_ORDER) DESC
LIMIT  
    3;