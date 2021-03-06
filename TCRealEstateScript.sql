USE [master]
GO
/****** Object:  Database [TCRealEstateAgency]    Script Date: 4/24/2017 4:00:45 PM ******/
CREATE DATABASE [TCRealEstateAgency]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TCRealEstateAgency', FILENAME = N'C:\Users\My DELL\TCRealEstateAgency.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TCRealEstateAgency_log', FILENAME = N'C:\Users\My DELL\TCRealEstateAgency_log.ldf' , SIZE = 784KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TCRealEstateAgency] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TCRealEstateAgency].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TCRealEstateAgency] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET ARITHABORT OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [TCRealEstateAgency] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TCRealEstateAgency] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TCRealEstateAgency] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET  ENABLE_BROKER 
GO
ALTER DATABASE [TCRealEstateAgency] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TCRealEstateAgency] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TCRealEstateAgency] SET  MULTI_USER 
GO
ALTER DATABASE [TCRealEstateAgency] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TCRealEstateAgency] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TCRealEstateAgency] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TCRealEstateAgency] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [TCRealEstateAgency]
GO
/****** Object:  Table [dbo].[AGENT]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AGENT](
	[AgentID] [int] NOT NULL,
	[FirstName] [varchar](20) NOT NULL,
	[LastName] [varchar](30) NOT NULL,
	[PhoneNumber] [char](10) NOT NULL,
	[BranchID] [char](4) NOT NULL,
	[HireDate] [date] NOT NULL,
	[DOB] [date] NOT NULL,
	[Gender] [char](1) NOT NULL,
	[Salary] [decimal](8, 2) NOT NULL,
	[ReportsTo] [int] NULL,
	[SocialSecNum] [char](9) NULL,
 CONSTRAINT [PK_Agent] PRIMARY KEY CLUSTERED 
(
	[AgentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_AgentName] UNIQUE NONCLUSTERED 
(
	[FirstName] ASC,
	[LastName] ASC,
	[PhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[APPOINTMENT]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[APPOINTMENT](
	[AppointmentID] [int] NOT NULL,
	[ScheduledDate] [date] NOT NULL,
	[ApptDate] [date] NOT NULL,
	[ApptTime] [time](7) NOT NULL,
	[ClientID] [char](6) NOT NULL,
	[PropertyID] [char](6) NOT NULL,
	[UnitID] [int] NOT NULL,
	[AgentID] [int] NOT NULL,
	[ApptStatus] [varchar](25) NOT NULL,
 CONSTRAINT [PK_Appt] PRIMARY KEY CLUSTERED 
(
	[AppointmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_Appt] UNIQUE NONCLUSTERED 
(
	[ApptDate] ASC,
	[ApptTime] ASC,
	[AgentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BRANCH]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BRANCH](
	[BranchID] [char](4) NOT NULL,
	[BranchName] [varchar](20) NOT NULL,
	[Street] [varchar](40) NOT NULL,
	[City] [varchar](30) NOT NULL,
	[BranchState] [char](2) NOT NULL,
	[Zip] [char](9) NULL,
	[PhoneNumber] [char](10) NOT NULL,
 CONSTRAINT [PK_Branch] PRIMARY KEY CLUSTERED 
(
	[BranchID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_BranchName] UNIQUE NONCLUSTERED 
(
	[BranchName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BUSINESSOWNER]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BUSINESSOWNER](
	[OwnerID] [char](6) NOT NULL,
	[BusinessName] [varchar](40) NOT NULL,
	[ContactFirstName] [varchar](20) NOT NULL,
	[ContactLastName] [varchar](35) NOT NULL,
	[ContactPhoneNumber] [char](10) NOT NULL,
 CONSTRAINT [UIX_CONTACTPHONE] UNIQUE NONCLUSTERED 
(
	[ContactPhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CLIENT]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENT](
	[ClientID] [char](6) NOT NULL,
	[FirstName] [varchar](30) NOT NULL,
	[LastName] [varchar](45) NOT NULL,
	[PhoneNumber] [char](10) NOT NULL,
	[Street] [char](45) NOT NULL,
	[City] [char](45) NOT NULL,
	[ClientState] [char](2) NOT NULL,
	[ClientZip] [char](9) NULL,
	[emailAddress] [char](50) NULL,
	[JoinedOn] [date] NOT NULL,
	[Region] [varchar](20) NOT NULL,
	[MaxRent] [decimal](8, 2) NOT NULL,
	[PropPrefType] [int] NOT NULL,
 CONSTRAINT [PK_ClientID] PRIMARY KEY CLUSTERED 
(
	[ClientID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LEASE]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LEASE](
	[LeaseNo] [int] NOT NULL,
	[DateSigned] [date] NOT NULL,
	[StartDate] [date] NOT NULL,
	[EndDate] [date] NOT NULL,
	[MonthlyRent] [decimal](10, 2) NOT NULL,
	[ClientID] [char](6) NOT NULL,
	[PropertyID] [char](6) NOT NULL,
	[UnitID] [int] NOT NULL,
 CONSTRAINT [PK_Lease] PRIMARY KEY CLUSTERED 
(
	[LeaseNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PAYMENT]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PAYMENT](
	[PaymentNo] [int] NOT NULL,
	[PaymentDate] [date] NOT NULL,
	[Amount] [decimal](10, 2) NOT NULL,
	[PaymentMethod] [varchar](15) NOT NULL,
	[LeaseNo] [int] NOT NULL,
	[PaymentType] [varchar](15) NOT NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[PaymentNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PRIVATEOWNER]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRIVATEOWNER](
	[OwnerID] [char](6) NOT NULL,
	[FirstName] [varchar](20) NOT NULL,
	[LastName] [varchar](35) NOT NULL,
 CONSTRAINT [PK_PRVTOWN] PRIMARY KEY CLUSTERED 
(
	[OwnerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROPERTY]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROPERTY](
	[PropertyID] [char](6) NOT NULL,
	[PropName] [varchar](20) NULL,
	[Street] [varchar](40) NOT NULL,
	[City] [varchar](30) NOT NULL,
	[PropertyState] [char](2) NOT NULL,
	[Zip] [char](9) NULL,
	[Zoning] [varchar](15) NOT NULL,
	[PropertyType] [int] NOT NULL,
	[NumUnits] [int] NOT NULL,
	[OwnerID] [char](6) NOT NULL,
	[BranchID] [char](4) NOT NULL,
	[AgentID] [int] NOT NULL,
 CONSTRAINT [PK_Property] PRIMARY KEY CLUSTERED 
(
	[PropertyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PropertyTypes]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PropertyTypes](
	[PropTypeID] [int] NOT NULL,
	[PropTypeDesc] [varchar](20) NOT NULL,
 CONSTRAINT [PK_PropType] PRIMARY KEY CLUSTERED 
(
	[PropTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_PropTypeDesc] UNIQUE NONCLUSTERED 
(
	[PropTypeDesc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PropertyUnit]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PropertyUnit](
	[PropertyID] [char](6) NOT NULL,
	[UnitID] [int] NOT NULL,
	[NumBedrooms] [int] NOT NULL,
	[NumBathrooms] [int] NOT NULL,
	[SquareFeet] [int] NOT NULL,
	[MonthlyRent] [decimal](8, 2) NOT NULL,
	[IsAvailable] [bit] NOT NULL,
	[FloorNum] [int] NOT NULL,
	[UnitCondition] [char](1) NULL,
	[PetsAllowed] [bit] NOT NULL,
 CONSTRAINT [PK_PropRentID] PRIMARY KEY CLUSTERED 
(
	[PropertyID] ASC,
	[UnitID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PROPOWNER]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PROPOWNER](
	[OwnerID] [char](6) NOT NULL,
	[Street] [varchar](40) NOT NULL,
	[City] [varchar](30) NOT NULL,
	[OwnerState] [char](2) NOT NULL,
	[ZipCode] [char](9) NULL,
	[PhoneNumber] [char](10) NOT NULL,
	[OwnerType] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Owner] PRIMARY KEY CLUSTERED 
(
	[OwnerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RENTER]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RENTER](
	[ClientID] [char](6) NOT NULL,
	[Salary] [decimal](8, 2) NOT NULL,
	[SocialSecNum] [char](9) NULL,
	[DriversLicenseID] [varchar](45) NULL,
	[CreditRating] [int] NOT NULL,
	[BalanceOwed] [decimal](10, 2) NOT NULL,
 CONSTRAINT [PK_Renter] PRIMARY KEY CLUSTERED 
(
	[ClientID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[VIEWING]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VIEWING](
	[AppointmentID] [int] NOT NULL,
	[AgentComments] [varchar](max) NULL,
	[ClientComments] [varchar](max) NULL,
	[WantsToRent] [bit] NOT NULL,
 CONSTRAINT [PK_Viewing] PRIMARY KEY CLUSTERED 
(
	[AppointmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Zoning]    Script Date: 4/24/2017 4:01:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Zoning](
	[ZoneID] [int] NOT NULL,
	[ZoneDescription] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Zoning] PRIMARY KEY CLUSTERED 
(
	[ZoneID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UIX_ZoneDesc] UNIQUE NONCLUSTERED 
(
	[ZoneDescription] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[APPOINTMENT] ADD  DEFAULT ('SCHEDULED') FOR [ApptStatus]
GO
ALTER TABLE [dbo].[RENTER] ADD  DEFAULT ((0.0)) FOR [BalanceOwed]
GO
ALTER TABLE [dbo].[VIEWING] ADD  DEFAULT ((0)) FOR [WantsToRent]
GO
ALTER TABLE [dbo].[AGENT]  WITH CHECK ADD  CONSTRAINT [FK_AGENT_BRANCH] FOREIGN KEY([BranchID])
REFERENCES [dbo].[BRANCH] ([BranchID])
GO
ALTER TABLE [dbo].[AGENT] CHECK CONSTRAINT [FK_AGENT_BRANCH]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [fk_Appt_Agent] FOREIGN KEY([AgentID])
REFERENCES [dbo].[AGENT] ([AgentID])
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [fk_Appt_Agent]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [fk_Appt_Client] FOREIGN KEY([ClientID])
REFERENCES [dbo].[CLIENT] ([ClientID])
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [fk_Appt_Client]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [fk_Appt_PropUnit] FOREIGN KEY([PropertyID], [UnitID])
REFERENCES [dbo].[PropertyUnit] ([PropertyID], [UnitID])
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [fk_Appt_PropUnit]
GO
ALTER TABLE [dbo].[BUSINESSOWNER]  WITH CHECK ADD  CONSTRAINT [PK_BUSINESSOWNER) primary key (OwnerID),
 constraint [FK_BUSINESSOWNER_OWNER] FOREIGN KEY([OwnerID])
REFERENCES [dbo].[PROPOWNER] ([OwnerID])
GO
ALTER TABLE [dbo].[BUSINESSOWNER] CHECK CONSTRAINT [PK_BUSINESSOWNER) primary key (OwnerID),
 constraint [FK_BUSINESSOWNER_OWNER]
GO
ALTER TABLE [dbo].[CLIENT]  WITH CHECK ADD  CONSTRAINT [FK_Client_PrefType] FOREIGN KEY([PropPrefType])
REFERENCES [dbo].[PropertyTypes] ([PropTypeID])
GO
ALTER TABLE [dbo].[CLIENT] CHECK CONSTRAINT [FK_Client_PrefType]
GO
ALTER TABLE [dbo].[CLIENT]  WITH CHECK ADD  CONSTRAINT [FK_Region_Branch] FOREIGN KEY([Region])
REFERENCES [dbo].[BRANCH] ([BranchName])
GO
ALTER TABLE [dbo].[CLIENT] CHECK CONSTRAINT [FK_Region_Branch]
GO
ALTER TABLE [dbo].[LEASE]  WITH CHECK ADD  CONSTRAINT [fk_Lease_Client] FOREIGN KEY([ClientID])
REFERENCES [dbo].[RENTER] ([ClientID])
GO
ALTER TABLE [dbo].[LEASE] CHECK CONSTRAINT [fk_Lease_Client]
GO
ALTER TABLE [dbo].[LEASE]  WITH CHECK ADD  CONSTRAINT [fk_Lease_PropUnit] FOREIGN KEY([PropertyID], [UnitID])
REFERENCES [dbo].[PropertyUnit] ([PropertyID], [UnitID])
GO
ALTER TABLE [dbo].[LEASE] CHECK CONSTRAINT [fk_Lease_PropUnit]
GO
ALTER TABLE [dbo].[PAYMENT]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Lease] FOREIGN KEY([LeaseNo])
REFERENCES [dbo].[LEASE] ([LeaseNo])
GO
ALTER TABLE [dbo].[PAYMENT] CHECK CONSTRAINT [FK_Payment_Lease]
GO
ALTER TABLE [dbo].[PRIVATEOWNER]  WITH CHECK ADD  CONSTRAINT [FK_PRIVATEOWNER_PROPOWNER] FOREIGN KEY([OwnerID])
REFERENCES [dbo].[PROPOWNER] ([OwnerID])
GO
ALTER TABLE [dbo].[PRIVATEOWNER] CHECK CONSTRAINT [FK_PRIVATEOWNER_PROPOWNER]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [FK_Property_Agent] FOREIGN KEY([AgentID])
REFERENCES [dbo].[AGENT] ([AgentID])
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [FK_Property_Agent]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [FK_Property_Branch] FOREIGN KEY([BranchID])
REFERENCES [dbo].[BRANCH] ([BranchID])
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [FK_Property_Branch]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [FK_Property_Owner] FOREIGN KEY([OwnerID])
REFERENCES [dbo].[PROPOWNER] ([OwnerID])
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [FK_Property_Owner]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [FK_Property_PropType] FOREIGN KEY([PropertyType])
REFERENCES [dbo].[PropertyTypes] ([PropTypeID])
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [FK_Property_PropType]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [FK_PropForRent_Prop] FOREIGN KEY([PropertyID])
REFERENCES [dbo].[PROPERTY] ([PropertyID])
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [FK_PropForRent_Prop]
GO
ALTER TABLE [dbo].[RENTER]  WITH CHECK ADD  CONSTRAINT [FK_Renter_Client] FOREIGN KEY([ClientID])
REFERENCES [dbo].[CLIENT] ([ClientID])
GO
ALTER TABLE [dbo].[RENTER] CHECK CONSTRAINT [FK_Renter_Client]
GO
ALTER TABLE [dbo].[VIEWING]  WITH CHECK ADD  CONSTRAINT [FK_Viewing_Appointment] FOREIGN KEY([AppointmentID])
REFERENCES [dbo].[APPOINTMENT] ([AppointmentID])
GO
ALTER TABLE [dbo].[VIEWING] CHECK CONSTRAINT [FK_Viewing_Appointment]
GO
ALTER TABLE [dbo].[AGENT]  WITH CHECK ADD  CONSTRAINT [CHK_Gender] CHECK  (([gender]='F' OR [gender]='M'))
GO
ALTER TABLE [dbo].[AGENT] CHECK CONSTRAINT [CHK_Gender]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [CHK_ApptDate] CHECK  (([ApptDate]>[ScheduledDate]))
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [CHK_ApptDate]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [CHK_ApptStatus] CHECK  (([ApptStatus]='COMPLETE' OR [ApptStatus]='CLIENTCANCEL' OR [ApptStatus]='AGNTCANCEL' OR [ApptStatus]='SCHEDULED'))
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [CHK_ApptStatus]
GO
ALTER TABLE [dbo].[APPOINTMENT]  WITH CHECK ADD  CONSTRAINT [CHK_ScheduledDate] CHECK  (([ScheduledDate]>getdate()))
GO
ALTER TABLE [dbo].[APPOINTMENT] CHECK CONSTRAINT [CHK_ScheduledDate]
GO
ALTER TABLE [dbo].[CLIENT]  WITH CHECK ADD  CONSTRAINT [CHK_MaxRent] CHECK  (([MaxRent]>=(1000)))
GO
ALTER TABLE [dbo].[CLIENT] CHECK CONSTRAINT [CHK_MaxRent]
GO
ALTER TABLE [dbo].[LEASE]  WITH CHECK ADD  CONSTRAINT [CHK_LeaseEndDate] CHECK  (([EndDate]>[StartDate]))
GO
ALTER TABLE [dbo].[LEASE] CHECK CONSTRAINT [CHK_LeaseEndDate]
GO
ALTER TABLE [dbo].[LEASE]  WITH CHECK ADD  CONSTRAINT [CHK_LeaseStartDate] CHECK  (([StartDate]>[DateSigned]))
GO
ALTER TABLE [dbo].[LEASE] CHECK CONSTRAINT [CHK_LeaseStartDate]
GO
ALTER TABLE [dbo].[PAYMENT]  WITH CHECK ADD  CONSTRAINT [chk_Amount] CHECK  (([Amount]>(0.0)))
GO
ALTER TABLE [dbo].[PAYMENT] CHECK CONSTRAINT [chk_Amount]
GO
ALTER TABLE [dbo].[PAYMENT]  WITH CHECK ADD  CONSTRAINT [chk_PaymentType] CHECK  (([PaymentType]='RENT' OR [PaymentType]='DEPOSIT'))
GO
ALTER TABLE [dbo].[PAYMENT] CHECK CONSTRAINT [chk_PaymentType]
GO
ALTER TABLE [dbo].[PAYMENT]  WITH CHECK ADD  CONSTRAINT [chk_PayMethod] CHECK  (([PaymentMethod]='CHECK' OR [PaymentMethod]='CASH' OR [PaymentMethod]='CREDITCARD'))
GO
ALTER TABLE [dbo].[PAYMENT] CHECK CONSTRAINT [chk_PayMethod]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [CHK_NumUnits] CHECK  (([NumUnits]>=(1)))
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [CHK_NumUnits]
GO
ALTER TABLE [dbo].[PROPERTY]  WITH CHECK ADD  CONSTRAINT [CHK_Zoning] CHECK  (([Zoning]='COMMERCIAL' OR [Zoning]='RESIDENTIAL'))
GO
ALTER TABLE [dbo].[PROPERTY] CHECK CONSTRAINT [CHK_Zoning]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [CHK_Condition] CHECK  (([UnitCondition]='P' OR [UnitCondition]='F' OR [UnitCondition]='G' OR [UnitCondition]='E' OR [UnitCondition]='N'))
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [CHK_Condition]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [CHK_FloorNum] CHECK  (([FloorNum]>=(1)))
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [CHK_FloorNum]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [CHK_MonthlyRent] CHECK  (([MonthlyRent]>(0)))
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [CHK_MonthlyRent]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [CHK_NumBathrooms] CHECK  (([NumBathrooms]>=(1) AND [NumBathrooms]<=(5)))
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [CHK_NumBathrooms]
GO
ALTER TABLE [dbo].[PropertyUnit]  WITH CHECK ADD  CONSTRAINT [CHK_NumBedRooms] CHECK  (([NumBedrooms]>=(0) AND [NumBedrooms]<=(10)))
GO
ALTER TABLE [dbo].[PropertyUnit] CHECK CONSTRAINT [CHK_NumBedRooms]
GO
ALTER TABLE [dbo].[PROPOWNER]  WITH CHECK ADD  CONSTRAINT [CHK_OwnType] CHECK  (([OwnerType]='PRIVATE' OR [OwnerType]='BUSINESS'))
GO
ALTER TABLE [dbo].[PROPOWNER] CHECK CONSTRAINT [CHK_OwnType]
GO
ALTER TABLE [dbo].[RENTER]  WITH CHECK ADD  CONSTRAINT [CHK_Identification] CHECK  (([SocialSecNum] IS NOT NULL OR [DriversLicenseID] IS NOT NULL))
GO
ALTER TABLE [dbo].[RENTER] CHECK CONSTRAINT [CHK_Identification]
GO
ALTER TABLE [dbo].[RENTER]  WITH CHECK ADD  CONSTRAINT [CHK_Rating ] CHECK  (([CreditRating]>=(670)))
GO
ALTER TABLE [dbo].[RENTER] CHECK CONSTRAINT [CHK_Rating ]
GO
USE [master]
GO
ALTER DATABASE [TCRealEstateAgency] SET  READ_WRITE 
GO
