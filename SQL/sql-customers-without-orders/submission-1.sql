-- Write your query below
-- SELECT NAME FROM T1 FROM T1 LEFT JOIN T2 ON T1.ID = T2.customer_id

-- SELECT T1.name
-- FROM customers AS T1
-- LEFT JOIN
-- orders AS T2
-- ON T1.id = T2.customer_id
-- WHERE T2.id IS NULL;

SELECT name 
FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders)

