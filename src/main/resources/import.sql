insert into CS_Organization (name, parent_id, id) values ('Camsys', null, 1);

insert into CS_User (token, name, email) values (null, 'Jeff Maki', 'jmaki@camsys.com');
insert into CS_UserOrganizationRole (user_email, role, organization_id) values ('jmaki@camsys.com', 'READ_WRITE', 1);

insert into CS_User (token, name, email) values (null, 'Matt Maranda', 'mmaranda@camsys.com');
insert into CS_UserOrganizationRole (user_email, role, organization_id) values ('mmaranda@camsys.com', 'READ_WRITE', 1);

insert into CS_Review(id, name, review_type, reviewer_id, reviewee_id, workflow_stage) VALUES(1, "Test Review", "Federal", 1, 1, "FINAL");
insert into CS_Review(id, name, review_type, reviewer_id, reviewee_id, workflow_stage) VALUES(2, "Matt Test Review", "Federal", 2, 2, "FINAL");
