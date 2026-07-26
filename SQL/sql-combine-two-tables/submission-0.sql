-- Write your query below
-- SELECT p.first_name, p.last_name, a.city, a.state 
-- FROM person as p LEFT JOIN ADDRESS as a ON p.person_id = a.person_id


SELECT first_name, last_name, city, state 
FROM person LEFT JOIN address ON person.person_id = address.person_id;