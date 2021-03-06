USE [master]
GO
/****** Object:  Database [onlinequiz_db]    Script Date: 7/19/2021 10:19:22 AM ******/
CREATE DATABASE [onlinequiz_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'onlinequiz_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\onlinequiz_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'onlinequiz_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\onlinequiz_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [onlinequiz_db] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [onlinequiz_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [onlinequiz_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [onlinequiz_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [onlinequiz_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [onlinequiz_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [onlinequiz_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [onlinequiz_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [onlinequiz_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [onlinequiz_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [onlinequiz_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [onlinequiz_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [onlinequiz_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [onlinequiz_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [onlinequiz_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [onlinequiz_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [onlinequiz_db] SET  ENABLE_BROKER 
GO
ALTER DATABASE [onlinequiz_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [onlinequiz_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [onlinequiz_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [onlinequiz_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [onlinequiz_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [onlinequiz_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [onlinequiz_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [onlinequiz_db] SET RECOVERY FULL 
GO
ALTER DATABASE [onlinequiz_db] SET  MULTI_USER 
GO
ALTER DATABASE [onlinequiz_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [onlinequiz_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [onlinequiz_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [onlinequiz_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [onlinequiz_db] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [onlinequiz_db] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'onlinequiz_db', N'ON'
GO
ALTER DATABASE [onlinequiz_db] SET QUERY_STORE = OFF
GO
USE [onlinequiz_db]
GO
/****** Object:  Table [dbo].[questions]    Script Date: 7/19/2021 10:19:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[questions](
	[question_id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](max) NOT NULL,
	[option1] [varchar](max) NOT NULL,
	[option2] [varchar](max) NOT NULL,
	[option3] [varchar](max) NOT NULL,
	[option4] [varchar](max) NOT NULL,
	[answer] [varchar](255) NOT NULL,
	[user_id] [int] NOT NULL,
	[created_at] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[question_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 7/19/2021 10:19:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 7/19/2021 10:19:23 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[role_id] [int] NOT NULL,
	[email] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[questions]  WITH CHECK ADD  CONSTRAINT [questions_users__fk] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[questions] CHECK CONSTRAINT [questions_users__fk]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [users_roles__fk] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([role_id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [users_roles__fk]
GO
USE [master]
GO
ALTER DATABASE [onlinequiz_db] SET  READ_WRITE 
GO
