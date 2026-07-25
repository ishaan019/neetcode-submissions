-- Write your query below


-- FROM exam_results
-- WHERE 

SELECT DISTINCT ON (student_id)
    student_id,
    exam_id,
    score
FROM exam_results
ORDER BY student_id, score DESC, exam_id;
