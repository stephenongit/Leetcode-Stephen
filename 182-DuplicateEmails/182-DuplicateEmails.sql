-- Last updated: 12/08/2026, 19:14:49
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;