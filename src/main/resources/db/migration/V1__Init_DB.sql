create table task_entity (
  task_id integer not null auto_increment,
  task_title varchar(255),
  task_text varchar(2048),
  source_sample varchar(2048),
  primary key (task_id)
) engine=MyISAM