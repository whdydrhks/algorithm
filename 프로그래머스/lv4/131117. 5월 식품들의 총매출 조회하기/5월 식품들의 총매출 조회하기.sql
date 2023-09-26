SELECT
    PRODUCT.PRODUCT_ID,
    PRODUCT.PRODUCT_NAME,
    SUM(PRODUCT.PRICE * FORDER.AMOUNT) AS TOTAL_SALES
FROM
    FOOD_PRODUCT AS PRODUCT
JOIN
    FOOD_ORDER AS FORDER
ON
    PRODUCT.PRODUCT_ID = FORDER.PRODUCT_ID
WHERE
    YEAR(FORDER.PRODUCE_DATE)=2022 AND MONTH(FORDER.PRODUCE_DATE)=5
GROUP BY
    PRODUCT.PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC,
    PRODUCT.PRODUCT_ID ASC;