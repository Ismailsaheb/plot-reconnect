INSERT INTO roles (id, name, description)
VALUES
  (1, 'ROLE_ADMIN', 'admin'),
  (2, 'ROLE_USER', 'user');

INSERT INTO persons (id, first_name, last_name, short_name, email, password, phone, birth_date, gender, created)
VALUES
  (1, 'Alex', 'Saunin', 'maniac', 'alsaunin@gmail.com', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '79211234567', '1984-03-23', 1, '2000-01-01'),
  (2, 'Vito', 'Corleone', 'vito', 'v_korleone@mail.ru', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '76545465465', '1891-12-07', 1, '2000-01-03'),
  (3, 'Vincent', 'Gigante', '', 'vinc@mail.ru', '$2a$10$CUrSYLzTe/zBeLTMMbvLluvMqykTmufwHYqiNQP6uVC0.PyMc/H8m', '76545465465', '1928-03-29', 1, '2000-01-11');
 
INSERT INTO user_roles (person_id, role_id) VALUES
  (1, 1), (1, 2), (2, 2);
INSERT INTO friends (person_id, friend_id) VALUES
  (2, 1), (1, 2);

INSERT INTO messages (id, posted, sender_id, recipient_id, body) VALUES

  (1, {ts '2016-07-26 01:15:19.0'}, 1, 2, 'I''m Ok, and you?\nHow are you getting on?'),
  (2, {ts '2016-07-26 01:15:45.0'}, 2, 1, 'Seems good enougth.\nWhat are you up to?\nHow do you in T-Systems?'),
  (3, {ts '2016-08-14 14:07:43.0'}, 2, 1, 'Hi Alex, glad to meet you here!'),
  (4, {ts '2016-08-14 14:09:30.0'}, 1, 2, 'Howdy Antony, long time no seen you!'),
  (5, {ts '2016-08-14 14:20:08.0'}, 2, 1, 'Buddy, can you add me in your friend list? Thx');