# Search Query

a proper SQL query with search feature (in this case, query is "query") will be like this:

```sql
SELECT
    DISTINCT q.id,
    q.author_id,
    q.content,
    q.create_date,
    q.modify_date,
    q.subject
FROM
    question q
    LEFT OUTER JOIN site_user u1 ON q.author_id=u1.id
    LEFT OUTER JOIN answer ON q.id=a.question_id 
    LEFT OUTER JOIN site_user u2 ON a.author_id=u2.id
WHERE
    q.subject LIKE '%query%'
    OR q.content LIKE '%query%'
    OR u1.username LIKE '%query%'
    OR a.content LIKE '%query%'
    OR u2.username LIKE '%query%'
;
```