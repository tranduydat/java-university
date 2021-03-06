USE [master]
GO
/****** Object:  Database [digitalnews_db]    Script Date: 7/19/2021 10:21:11 AM ******/
CREATE DATABASE [digitalnews_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'digitalnews_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\digitalnews_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'digitalnews_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\digitalnews_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [digitalnews_db] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [digitalnews_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [digitalnews_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [digitalnews_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [digitalnews_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [digitalnews_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [digitalnews_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [digitalnews_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [digitalnews_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [digitalnews_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [digitalnews_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [digitalnews_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [digitalnews_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [digitalnews_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [digitalnews_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [digitalnews_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [digitalnews_db] SET  ENABLE_BROKER 
GO
ALTER DATABASE [digitalnews_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [digitalnews_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [digitalnews_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [digitalnews_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [digitalnews_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [digitalnews_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [digitalnews_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [digitalnews_db] SET RECOVERY FULL 
GO
ALTER DATABASE [digitalnews_db] SET  MULTI_USER 
GO
ALTER DATABASE [digitalnews_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [digitalnews_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [digitalnews_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [digitalnews_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [digitalnews_db] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [digitalnews_db] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'digitalnews_db', N'ON'
GO
ALTER DATABASE [digitalnews_db] SET QUERY_STORE = OFF
GO
USE [digitalnews_db]
GO
/****** Object:  Table [dbo].[authors]    Script Date: 7/19/2021 10:21:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authors](
	[author_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](55) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[author_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[posts]    Script Date: 7/19/2021 10:21:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[posts](
	[post_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NOT NULL,
	[excerpt] [ntext] NULL,
	[content] [ntext] NULL,
	[author_id] [int] NOT NULL,
	[thumbnail] [nvarchar](255) NULL,
	[date_published] [datetime] NULL,
	[date_modified] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[posts] ADD  DEFAULT ((0)) FOR [author_id]
GO
ALTER TABLE [dbo].[posts] ADD  DEFAULT (getdate()) FOR [date_modified]
GO
ALTER TABLE [dbo].[posts]  WITH CHECK ADD  CONSTRAINT [posts_author_id__fk] FOREIGN KEY([author_id])
REFERENCES [dbo].[authors] ([author_id])
GO
ALTER TABLE [dbo].[posts] CHECK CONSTRAINT [posts_author_id__fk]
GO
USE [master]
GO
ALTER DATABASE [digitalnews_db] SET  READ_WRITE 
GO
