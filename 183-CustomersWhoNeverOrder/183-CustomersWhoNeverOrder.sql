-- Last updated: 12/08/2026, 19:14:47
SELECT
    c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.id IS NULL;