-- Write your query below

SELECT c.customer_id, c.customer_name
FROM customers AS c
WHERE c.customer_id IN (
    Select customer_id from orders where product_name = 'A'
) 
AND c.customer_id IN (
    Select customer_id from orders where product_name = 'B'
) AND c.customer_id NOT IN (
    Select customer_id from orders where product_name = 'C'
) 
ORDER BY c.customer_name;



-- customer_id	customer_name
-- 1	Alice A,B,C,D
-- 1	Alice B
-- 1	Alice C
-- 1	Alice D

-- 2	Bob
-- 3	Carol
-- 4	Dave