create database leyao2;
use leyao2;
CREATE TABLE `leyao_web2` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_parent_id` int(11) NOT NULL DEFAULT '0',
  `item_type` int(11) NOT NULL DEFAULT '1' COMMENT '1:item; 2:header; 3:footer; 4:audio; 5:vedio',
  `item_name` varchar(50) NOT NULL DEFAULT '?',
  `item_url` varchar(100) NOT NULL DEFAULT '?',
  `item_order` int(11) NOT NULL DEFAULT '-1',
  `item_length` int(11) DEFAULT '-1',
  `item_width` int(11) DEFAULT '-1',
  `is_delete` int(11) NOT NULL DEFAULT '0',
  `create_username` varchar(30) DEFAULT NULL,
  `create_timestamp` datetime DEFAULT NULL,
  `update_username` varchar(30) DEFAULT NULL,
  `update_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

INSERT INTO leyao2.leyao_web2 (item_id,item_parent_id,item_type,item_name,item_url,item_order,item_length,item_width,is_delete,create_username,create_timestamp,update_username,update_timestamp) VALUES 
(1,0,3,'f1','footer/f1.jpg',1,950,300,0,NULL,NULL,NULL,NULL)
,(2,0,2,'h1','header/h1.jpg',1,72,44,0,NULL,NULL,NULL,NULL)
,(3,0,2,'h2','header/h2.jpg',1,72,44,0,NULL,NULL,NULL,NULL)
,(4,0,2,'h3','header/h3.jpg',1,72,44,0,NULL,NULL,NULL,NULL)
,(6,0,1,'item_list1','item_list/item_list1.jpg',1,4482,2800,0,NULL,NULL,NULL,NULL)
,(7,0,1,'item_list2','item_list/item_list2.jpg',2,4482,2800,0,NULL,NULL,NULL,NULL)
,(8,0,1,'item_list3','item_list/item_list3.jpg',3,4482,2800,0,NULL,NULL,NULL,NULL)
,(9,0,1,'item_list4','item_list/item_list4.jpg',4,4482,2800,0,NULL,NULL,NULL,NULL)
,(10,0,1,'item_list5','item_list/item_list5.jpg',5,4482,2800,0,NULL,NULL,NULL,NULL)
,(11,1,1,'item1','items/item1.jpg',1,950,1200,0,NULL,NULL,NULL,NULL)
,(12,1,1,'item2','items/item2.jpg',1,950,1200,0,NULL,NULL,NULL,NULL)
,(13,3,1,'item3','items/item3.jpg',0,950,1500,0,NULL,NULL,NULL,NULL)
,(14,3,1,'item4','items/item4.jpg',1,950,1200,0,NULL,NULL,NULL,NULL)
,(16,6,1,'item6','items/item6.jpg',1,950,1500,0,NULL,NULL,NULL,NULL)
,(17,7,1,'item7','items/item7.jpg',1,950,1500,0,NULL,NULL,NULL,NULL)
,(18,8,1,'item8','items/item8.jpg',1,950,1500,0,NULL,NULL,NULL,NULL)
,(19,9,1,'item9','items/item9.jpg',1,950,1500,0,NULL,NULL,NULL,NULL)
,(20,10,1,'item10','items/item10.jpg',1,950,1500,0,NULL,NULL,NULL,NULL)
;