USE [PRJ321_SP21_B1]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/3/2021 9:42:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[accountid] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 3/3/2021 9:42:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[pid] [int] NOT NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Event]    Script Date: 3/3/2021 9:42:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Event](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[date] [date] NOT NULL,
	[isEnabled] [bit] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Event] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Post]    Script Date: 3/3/2021 9:42:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Post](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[date] [date] NOT NULL,
	[isEnabled] [bit] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Post] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Record]    Script Date: 3/3/2021 9:42:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Record](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[eid] [int] NOT NULL,
 CONSTRAINT [PK_Record] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mra', N'mra')
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mrb', N'mrb')
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mrc', N'mrc')
INSERT [dbo].[Account] ([accountid], [password]) VALUES (N'mrd', N'mrd')
SET IDENTITY_INSERT [dbo].[Comment] ON 

INSERT [dbo].[Comment] ([id], [content], [pid]) VALUES (1, N'Comment 1 on Post 1', 1)
INSERT [dbo].[Comment] ([id], [content], [pid]) VALUES (2, N'Comment 2 on Post 1', 1)
INSERT [dbo].[Comment] ([id], [content], [pid]) VALUES (3, N'Comment 3 on Post 1', 1)
INSERT [dbo].[Comment] ([id], [content], [pid]) VALUES (4, N'Comment 1 on Post 2', 2)
INSERT [dbo].[Comment] ([id], [content], [pid]) VALUES (5, N'Comment 2 on Post 2', 2)
SET IDENTITY_INSERT [dbo].[Comment] OFF
SET IDENTITY_INSERT [dbo].[Event] ON 

INSERT [dbo].[Event] ([id], [content], [date], [isEnabled], [created_by]) VALUES (1, N'Event number 1', CAST(N'2021-01-01' AS Date), 1, N'mra')
INSERT [dbo].[Event] ([id], [content], [date], [isEnabled], [created_by]) VALUES (2, N'Event number 2', CAST(N'2021-01-02' AS Date), 0, N'mra')
INSERT [dbo].[Event] ([id], [content], [date], [isEnabled], [created_by]) VALUES (3, N'Event number 3', CAST(N'2021-01-03' AS Date), 1, N'mra')
INSERT [dbo].[Event] ([id], [content], [date], [isEnabled], [created_by]) VALUES (4, N'Event number 4', CAST(N'2021-02-15' AS Date), 1, N'mrb')
INSERT [dbo].[Event] ([id], [content], [date], [isEnabled], [created_by]) VALUES (5, N'Event number 5', CAST(N'2021-03-14' AS Date), 0, N'mrb')
SET IDENTITY_INSERT [dbo].[Event] OFF
SET IDENTITY_INSERT [dbo].[Post] ON 

INSERT [dbo].[Post] ([id], [content], [date], [isEnabled], [created_by]) VALUES (1, N'Post 1', CAST(N'2021-01-01' AS Date), 1, N'mra')
INSERT [dbo].[Post] ([id], [content], [date], [isEnabled], [created_by]) VALUES (2, N'Post 2', CAST(N'2021-01-02' AS Date), 0, N'mra')
INSERT [dbo].[Post] ([id], [content], [date], [isEnabled], [created_by]) VALUES (3, N'Post 3', CAST(N'2021-01-03' AS Date), 1, N'mra')
INSERT [dbo].[Post] ([id], [content], [date], [isEnabled], [created_by]) VALUES (4, N'Post 4', CAST(N'2021-02-15' AS Date), 1, N'mrb')
INSERT [dbo].[Post] ([id], [content], [date], [isEnabled], [created_by]) VALUES (5, N'Post 5', CAST(N'2021-03-14' AS Date), 0, N'mrc')
SET IDENTITY_INSERT [dbo].[Post] OFF
SET IDENTITY_INSERT [dbo].[Record] ON 

INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (7, N'Record 1 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (8, N'Record 2 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (9, N'Record 3 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (10, N'Record 1 on Event 2', 2)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (11, N'Record 2 on Event 2', 2)
SET IDENTITY_INSERT [dbo].[Record] OFF
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Post] FOREIGN KEY([pid])
REFERENCES [dbo].[Post] ([id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Post]
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD  CONSTRAINT [FK_Event_Account] FOREIGN KEY([created_by])
REFERENCES [dbo].[Account] ([accountid])
GO
ALTER TABLE [dbo].[Event] CHECK CONSTRAINT [FK_Event_Account]
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_Account] FOREIGN KEY([created_by])
REFERENCES [dbo].[Account] ([accountid])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_Account]
GO
ALTER TABLE [dbo].[Record]  WITH CHECK ADD  CONSTRAINT [FK_Record_Event] FOREIGN KEY([eid])
REFERENCES [dbo].[Event] ([id])
GO
ALTER TABLE [dbo].[Record] CHECK CONSTRAINT [FK_Record_Event]
GO
