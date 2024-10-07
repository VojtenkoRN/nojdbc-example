TRUNCATE TABLE a CASCADE;
TRUNCATE TABLE b CASCADE;
TRUNCATE TABLE c CASCADE;
TRUNCATE TABLE main CASCADE;
TRUNCATE TABLE mtm_main_c CASCADE;

INSERT INTO main (id, boolean_field, int_field, long_field, float_field, double_field, string_field, enum_field,
                  timestamp_field, nullable_int_field)
VALUES ('c06ac260-0b46-4f32-a35a-3bf225845a4a', true, 1, 9223372036854775800, 2.71, 9.80665, ':)',
        'VALUE_1', '2024-10-06 17:08:00.000000', null);

INSERT INTO a (id, value, oto_main)
VALUES ('f7d44e93-dbf2-4430-8ebc-e5a220ffd740', 'Я сразу смазал карту будня, плеснувши краску из стакана;',
        'c06ac260-0b46-4f32-a35a-3bf225845a4a');

INSERT INTO b (id, value, otm_main)
VALUES ('a5158041-d76a-4b55-8dc5-0d22fa097353', 'я показал на блюде студня косые скулы океана.',
        'c06ac260-0b46-4f32-a35a-3bf225845a4a'),
       ('a49db57d-1962-4332-b4df-1c6629598ce2', 'На чешуе жестяной рыбы прочёл я зовы новых губ.',
        'c06ac260-0b46-4f32-a35a-3bf225845a4a');

INSERT INTO c (id, value)
VALUES ('7b2baa66-2f92-4621-9427-ed1abcbebb29', 'А вы'),
       ('c4f76da1-bd53-4b83-bc5a-e85a256826e9', 'ноктюрн сыграть'),
       ('050172de-e27e-4a45-a0bf-89099085c6ef', 'могли бы'),
       ('513af8c3-8c90-4fa2-95e9-81979084d461', 'на флейте водосточных труб?');

INSERT INTO mtm_main_c (main_id, c_id)
VALUES ('c06ac260-0b46-4f32-a35a-3bf225845a4a', '7b2baa66-2f92-4621-9427-ed1abcbebb29'),
       ('c06ac260-0b46-4f32-a35a-3bf225845a4a', 'c4f76da1-bd53-4b83-bc5a-e85a256826e9'),
       ('c06ac260-0b46-4f32-a35a-3bf225845a4a', '050172de-e27e-4a45-a0bf-89099085c6ef'),
       ('c06ac260-0b46-4f32-a35a-3bf225845a4a', '513af8c3-8c90-4fa2-95e9-81979084d461');