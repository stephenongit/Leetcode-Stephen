-- Last updated: 12/08/2026, 19:11:12
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;