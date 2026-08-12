-- Last updated: 12/08/2026, 19:11:29
SELECT name
FROM Customer
WHERE referee_id <> 2
   OR referee_id IS NULL;