CREATE TABLE board(
	board_no INT(3) auto_increment,
	title VARCHAR(60),
	content VARCHAR(300),
	view_count INT(3),
	reg_datetime DATETIME,
	constraint board_no
	primary key (board_no)
);

SELECT * FROM board;

DELETE FROM board WHERE board_no=12;
DELETE FROM board WHERE board_no=1;