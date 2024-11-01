-- Create User Table
CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
    `roles` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '(DC2Type:json)' CHECK (json_valid(`roles`)),
    `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UNIQ_IDENTIFIER_EMAIL` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- INSERT INTO `user` (`id`, `email`, `roles`, `password`) VALUES
--     (1, 'michel@mail.Dev', '["ROLE_ADMIN"]', 'password');