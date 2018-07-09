create table task_entity (
  id integer not null auto_increment,
  task_title varchar(255),
  task_text varchar(2048),
  source_sample varchar(2048),
  primary key (id)
) engine=MyISAM