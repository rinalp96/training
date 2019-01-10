use session;

create table cardPresent as SELECT id from authors;
alter table cardPresent add column cardStatus bool;
update cardPresent set hasCard = false;
uPDATE cardPresent t1 INNER JOIN authors t2 ON t1.id = t2.id SET t1.birthdate = t2.birthdate


select authors.id, first_name, last_name,cardStatus, authors.birthdate from authors,cardPresent where authors.id = cardPresent.id and authors.birthdate BETWEEN CURDATE() - INTERVAL 2000 YEAR  AND CURDATE() - INTERVAL 18 YEAR and cardStatus = false;


update cardPresent set cardStatus = true where birthdate BETWEEN CURDATE() - INTERVAL 2000 YEAR  AND CURDATE() - INTERVAL 18 YEAR and cardStatus = false;


