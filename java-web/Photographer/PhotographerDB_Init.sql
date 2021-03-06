USE [master]
GO
/****** Object:  Database [photographer_db]    Script Date: 7/19/2021 10:20:43 AM ******/
CREATE DATABASE [photographer_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'photographer_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\photographer_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'photographer_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\photographer_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [photographer_db] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [photographer_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [photographer_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [photographer_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [photographer_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [photographer_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [photographer_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [photographer_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [photographer_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [photographer_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [photographer_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [photographer_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [photographer_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [photographer_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [photographer_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [photographer_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [photographer_db] SET  ENABLE_BROKER 
GO
ALTER DATABASE [photographer_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [photographer_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [photographer_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [photographer_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [photographer_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [photographer_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [photographer_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [photographer_db] SET RECOVERY FULL 
GO
ALTER DATABASE [photographer_db] SET  MULTI_USER 
GO
ALTER DATABASE [photographer_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [photographer_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [photographer_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [photographer_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [photographer_db] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [photographer_db] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'photographer_db', N'ON'
GO
ALTER DATABASE [photographer_db] SET QUERY_STORE = OFF
GO
USE [photographer_db]
GO
/****** Object:  Table [dbo].[authors]    Script Date: 7/19/2021 10:20:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authors](
	[id] [int] NOT NULL,
	[address] [nvarchar](50) NULL,
	[city] [nvarchar](30) NULL,
	[country] [nvarchar](25) NULL,
	[phone] [nvarchar](13) NULL,
	[email] [nvarchar](255) NULL,
	[about_me] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[galleries]    Script Date: 7/19/2021 10:20:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[galleries](
	[id] [int] NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[thumbnail] [nvarchar](255) NOT NULL,
	[description] [ntext] NULL,
	[author_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[images]    Script Date: 7/19/2021 10:20:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[images](
	[gallery_id] [int] NOT NULL,
	[image_url] [nvarchar](255) NOT NULL,
	[caption] [nvarchar](255) NULL,
	[is_featured] [bit] NOT NULL,
 CONSTRAINT [PK_images] PRIMARY KEY CLUSTERED 
(
	[gallery_id] ASC,
	[image_url] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[stats]    Script Date: 7/19/2021 10:20:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[stats](
	[id] [int] NOT NULL,
	[type] [varchar](255) NOT NULL,
	[value] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[images] ADD  DEFAULT ((0)) FOR [is_featured]
GO
ALTER TABLE [dbo].[galleries]  WITH CHECK ADD  CONSTRAINT [FK_galleries_authors] FOREIGN KEY([author_id])
REFERENCES [dbo].[authors] ([id])
GO
ALTER TABLE [dbo].[galleries] CHECK CONSTRAINT [FK_galleries_authors]
GO
ALTER TABLE [dbo].[images]  WITH CHECK ADD  CONSTRAINT [FK_images_galleries] FOREIGN KEY([gallery_id])
REFERENCES [dbo].[galleries] ([id])
GO
ALTER TABLE [dbo].[images] CHECK CONSTRAINT [FK_images_galleries]
GO
USE [master]
GO
ALTER DATABASE [photographer_db] SET  READ_WRITE 
GO
