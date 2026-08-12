-- Last updated: 8/12/2026, 12:13:05 PM
SELECT
    eu.unique_id,
    e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON e.id = eu.id;