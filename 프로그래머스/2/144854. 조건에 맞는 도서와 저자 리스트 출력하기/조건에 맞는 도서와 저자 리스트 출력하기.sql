-- 코드를 입력하세요
select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d')
from book b join author a on b.author_id = a.author_id
where b.category = "경제"
order by published_date;