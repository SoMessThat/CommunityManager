# CommunityManager
学生社团管理系统



基于SSM框架开发的社团管理系统 
摘要
随着时代的发展，现在已经进入了人工智能的时代。如今多种多样的APP和web应用方便我们的生活。并且在这个属于我们的大学时代中，社团活动是必不可少的环节，它充实了我们的大学生活，让我们各个方面的锻炼。
然尔在现阶段，学生社团的活动都是通过纸质报告开展的，并且一些事物无法透明公开，但常常我们希望能过把事情公布给学生，学生能够及时透明的了解到社团活动的事务。例如学生会下的各种组织，每个组织有各种活动。他们需要各种样式的表格，但是如果能用一个系统，将纸质文档的工作减轻，则会大大减少工作量，并且将评比过程透明化，这将会促进社团的发展，规范完善学生社团管理制度。
因此这个社团管理系统正是为了满足这些需求而被提出的，在这个系统中每个人可以各尽其职，有效率地完成每个工作。它还有强大的报表功能，通过各种柱状图，扇形图，折线图直观的表现出校园的情况，从而完美的展现出社团管理系统的便利性。
这个社团管理系统是基于SSM框架所开发的。 它结合了Spring、Spring MVC、和Mybatis的优势。轻量型，速度快，效率高，通过控制反转和面向切面的方法，让我们不再关注各个对象的依赖关系，从而方便解耦，简化了开发，不仅如此，它还解除了sql语句和代码的耦合，还可利用xml标签，支持动态的sql。并且，系统还使用了ECharts的表格，将零散的数据整理成了可视化的数据。增强了用户体验。
关键词：社团活动，社团管理，SSM框架，ECharts


Community Management system based on SSM
Abstract
With the development of the times, it has now entered the era of artificial intelligence. Today, a wide variety of app and web applications are convenient for our lives. And in this era of our university, the clubs activities are an essential part, and it has enriched our university life and let us exercise every aspect of our life.
In the present stage, the activities of the students associations are carried out through paper-based reports, and some things are not transparent, but often we want to be able to publish the matter to the students, and the students can be informed of the affairs of the community in a timely and transparent manner. Such as various organizations under the student union, each having a variety of activities. They need a variety of forms, but if a system can be used to reduce the work of the paper document, the workload will be greatly reduced, and the evaluation process will be transparent, which will promote the development of the community and standardize the student’s community management system. 
Therefore, the community management system is proposed to meet these needs, in which each person can do his or her job efficiently and efficiently. It also has a powerful report function, through a variety of column charts, fan charts; line charts intuitively show the situation of the campus, so as to perfectly show the convenience of the community management system. 
This community management system is based on the SSM framework. It combines the advantages of Spring, Spring MVC, and Mybatis. Lightweight, high speed, high efficiency, through inversion of control and aspect-oriented approach, let us no longer focus on the dependence of each object, thus facilitating decoupling, simplifying development, and uncoupling sql statements and code, You can also take advantage of xml tags to support dynamic sql. Moreover, the system uses ECharts tables to organize scattered data into visual data. Enhanced user experience.
Key words：Club events, Community Management, SSM, ECharts
目录
1 绪论	1
1.1课题研究的背景	1
1.2课题研究的意义	1
2 开发方案论证	2
2.1 开发环境概述	2
2.1.1 JDK8.0	2
2.1.2 Eclipse	2
2.1.3 Tomcat	2
2.1.4 MySql	2
2.2 相关技术介绍	3
2.2.1 SSM简介	3
2.2.2 LayUI简介	3
2.2.3 ECharts简介	3
2.2.4 简单三层架构设计模式	3
3 可行性分析及需求分析	4
3.1可行性分析	4
3.1.1技术可行性	4
3.1.2操作可行性	4
3.1.3经济可行性	4
3.1.4法律可行性	4
3.2需求分析	5
3.2.1需求概述	5
3.2.2学生干事功能分析	6
3.2.3部门干部功能分析	6
3.2.3部门领导功能分析	7
4 总体设计	8
4.1系统架构概述	8
4.2系统功能图设计	8
4.3系统业务流程设计	8
4.3.1业务流程概述	8
4.3.2业务流程图	9
4.4数据库设计	10
4.4.1数据库E-R图	10
4.4.2系统数据表	13
5 详细设计与实现	19
5.1干事功能详细设计	19
5.1.1 查看及修改个人信息	19
5.1.2 会议签到	20
5.1.3 缴纳费用	22
5.1.4 提交工作报告	22
5.1.5 提交工作总结	23
5.1.6 填写策划	24
5.2部门干部功能详细设计	26
5.2.1 部门干部首页	26
5.2.2 修改部门信息	26
5.2.3 发布会议	27
5.2.4 管理干事	28
5.2.5 审查工作报告	30
5.2.6审查工作总结	30
5.3领导功能详细设计	31
5.3.1 部门领导首页	31
5.3.2 查看统计信息	31
5.3.3 审查策划	32
5.3.4 审查工作总结	32
5.3.5 发布通知	33
5.3.5 评选优秀干部干事	33
5.3.5管理部门人员	34
5.3.5 管理权限	34
5.3.5 管理部门	35
6 软件测试	37
6.1 软件测试的目的	37
6.2 软件测试方案	37
6.3 软件测试结论	37
7 结语	38
8 致谢	39
9 参考文献	40


1 绪论
1.1课题研究的背景
在这个人工智能的时代。如今多种多样的APP和web应用方便我们的生活。各种各样的生活方式也让我们的大学生活多姿多彩。然尔在现阶段，学生社团的活动都是通过纸质报告开展的，但每个组织有各自的活动。自律会需要上课点名，宿舍卫生检查。他们都是自己打印报表，然后上交后再统计，所以他们需要一个可移植，简单稳定的系统。使用这一个系统，将纸质文档的工作减轻，减少工作量，让他们从麻烦的社团活动中解脱出来。而且在福州范围内还暂时没有一款是有关于社团管理的软件，所以让这个系统有着十分大的潜力，并且能够结合学院教务系统的其他数据，让数据共享，更加方便管理校园的事务。
因此这个社团管理系统是为了满足这些需求而被提出的，使用这个系统后每个人可以各尽其职，有效率地完成每个工作。并且不仅仅是减少工作量，减少经费浪费。它还有需要强大的报表功能，通过各种柱状图，扇形图，折线图直观的表现出校园的情况，从而完美的展现出社团管理系统的便利性，不仅仅方便学生的工作，还有方便了社团管理人的工作安排和学校的统计数据，增强了用户体验。因此这个系统主要研究学生，社团成员，社团管理员的日常需求。从而有效的完成各种模块。

1.2课题研究的意义
由于现在校园缺少社团管理系统，所以在社团活动上，干部们要花费许多脑力人力去统计或者思考社团的事务，干事们也要花费许多精力在重复而繁琐的统计报表等等有关于社团发展和每日的事情，这将会浪费很多的人力物力，然而效率低下，成效慢。因此这个社团管理系统能够提高社团的办事效率，减轻每个人的负担，能够让一个人完成原本两个人的工作量。其次在社团的管理中，这个系统也能体现出非常好的优势。使用这个系统可以统一管理，实现开会签到，费用缴纳，策划一键生成，纳新等等。
最主要的是如果这个系统能够投入使用，那么将会在很长的一段时间无法被替代，他可以被很多个社团部门所使用，在每年的优秀干部评选以及工作汇报中，也能使用这个系统完成这些事务。在这个互联网时代，我们只要动动手指，就能够完成很多事情，利用互联网的便捷，应该是我们每个大学生的必备技能。因此在实用性能上，还是十分需要这个软件。不仅如此，经过调查许多部门的干部干事，他们一大部分也都表示需要这样的一个系统来解决他们每天的问题。
2 开发方案论证
2.1 开发环境概述
本系统使用Eclipse作为开发工具。采用Java作为开发语言，且使用jkd1.8；主要框架为Spring + Spring MVC + Mybatis + LayUI，数据存储则采用MySQL。

2.1.1 JDK8.0
JDK作为开发环境中最为基础的环境配置，JDK由一个标准类库和一组建立，测试及建立文档的Java实用程序组成。开发人员需要用这些类来访问Java语言的功能。JDK8.0的版本比7.0版更加了稳定，并且1.8相对于1.7进行了一系列的优化，在兼容上也增加了许多。

2.1.2 Eclipse
Eclipse是一个可扩展的开放源代码的集成开发环境（IDE）。也是被公认为业界最好的java开发工具之一，并且拥有免费，纯Java语言编写，免安装，拓展性强 的特点。并且集成了代码编写功能，分析功能，编译功能，调试功能等一体化的开发软件。由于配置简单，所以成为了很多用户的选择。上手简单，仅仅只需要配置jdk，Tomcat，以及maven就能够完成基本的需求了。

2.1.3 Tomcat
Tomcat是一个web应用服务器，也可以称作是jsp/servlet容器，Tomcat不仅可以相应web应用而且自身集成了http服务，是一个高效的web服务器。Tomcat虽然本身的结构很复杂，但是同时Tomcat也高度的模块化。基于Java的Web 应用程序是 servlet、JSP 页面、静态页面、类和其他资源的集合，它们可以用标准方式打包，并运行在来自多个供应商的多个容器。并且它是一个开源免费的。所以它广泛运用在中小型系统和并发接入用户中。它的性能相对来说比较稳定，所以成为流行的应用服务器，并且配置简单，只需要配置端口号即好。

2.1.4 MySql
MySQL数据库。在国内是算主流的数据库。因为它的速度快，成本低，体积小，开源，所以被国内中小型甚至大型公司所使用。不仅因为它是免费，开源；而且可以撑持多种操作系统，同时撑持多线程，并撑持存储进程，所以MySQL是非常灵活的一款数据库，虽然它不是绝对完美，但它的灵活足够适应很多高要求的环境。由于它具备 很多长处：速度快，成本低，体积小，开源。所以，一般中小公司都会优先选择使用它。并且相对于oracle，它还带有分页的关键字，所以可以不用写一大段的存储过程，所以，对于小项目，mysql便是首选。
2.2 相关技术介绍
2.2.1 SSM简介 
SSM框架是由Spring + Spring MVC + MyBatis的缩写，Spring依赖注入DI来管理各层的组件，使用面向切面编程AOP管理事物、日志、权限等。SpringMVC代表了Model(模型)，View(视图)，Controller(控制)接收外部请求,进行分发和处理。Mybatis是基于jdbc的框架,主要用来操作数据库,并且将业务实体和数据表联系起来。使用SSM框架让对象的依赖关系交给了Spring控制，方便解耦，能够大层度的简化了开发。

2.2.2 LayUI简介
LayUI是一款采用自身模块规范编写的前端 UI 框架，门槛很低，能够很快上手，拿来即用。他的展现方式极其简单，却又不失饱满的内在，从核心代码到 API 的每一处细节都经过精心雕琢，非常适合界面的快速开发。LayUI包含了许多组件，例如：布局、颜色、字体图标、动画、按钮、表单、导航条等等。并且LayUI提供了丰富的内置模块，他们皆可通过模块化的方式按需加载。

2.2.3 ECharts简介
ECharts是一款用于数据可视化的框架，也是商业级数据图表，它是一个纯JavaScript的图标库，兼容绝大部分的浏览器，它包含了非常丰富的图表类型。不仅提供常见的如折线图，柱状图，散点图，饼图，K线图等图表类型，而且ECharts 提供了用于地理数据可视化的地图，热力图，线图，用于关系数据可视化的关系图，多维数据可视化的平行坐标，还有用于 BI 的漏斗图，仪表盘，并且支持图与图之间的混搭。在数据展现方面，给予了用户非常有好的视觉体验，将数据淋漓尽致的通过图表的方式展现了出来。

2.2.4 简单三层架构设计模式
该管理系统整体设计模式是采用三层架构模式（MVC）。由于为了减少项目的耦合度，并且为了使代码在结构上比较清晰，使系统减少维护量以及二次开发，故选用了三层架构的设计模式。分别是数据访问层，主要用于对数据库的操作，所以数据访问层里面有没有包含逻辑处理；业务逻辑层，主要用于前端数据与后端数据库进行交互的中间层，即对数据层的操作，对数据业务逻辑处理；用户界面层，主要表示WEB方式，主要用来展示数据与美化界面。 因此三层架构（MVC）模式项目开发中有着分工明确，代码结构清晰等的优点。

3 可行性分析及需求分析
3.1可行性分析
可行性分析在软件设计的初级阶段也是尤为重要的。该社团管理系统从可行性上分析，该系统是给学生及学校职工使用的，用来解决学生干事在社团活动上多而杂，学校领导管理社团上流程麻烦等诸多问题，所以从以下的分析中可以得知这个系统是值得研发的。那么以下是从详细的可行性分析方案来研究这个问题的可行性。

3.1.1技术可行性
软件方面：采用JDK1.8，选用eclipse作为工具， MySQL可作为数据库，使用Java语言编写。这些都是开源的软件，并且对技术的要求不高，简单易开发。
硬件方面：由于该社团管理系统是B/S的系统，只要安装了浏览器，并且连接网络便可以使用，并不需要消耗大量的内存，所以对客户端的硬件要求不高。	
因为开发该系统并不需要特意学习特别深奥的知识，相对于我们这个阶段的技术水平便可以完成这个项目，因此分析得出在技术可行性上是可行的。

3.1.2操作可行性
    该系统是应用与浏览器上的系统，并不需要太多花费时间学习，只需要操控鼠标以及键盘就能完成一系列原本复杂的流程。使用简单友好的界面，简洁精炼的语言，能够让用户很快上手,并不需要多做培训，所以最后分析出在操作可行性上也是可行的。

3.1.3经济可行性
在经济上，这个系统并不需要购买很多配置，也不需要聘请专业技术人员，因为开发周期短，后期维护简单，并且容易移植及扩展，所以不需要花费太多的费用。而具体的花费仅仅需要一台电脑，一个宽带网络便足够了。因此在经济可行性上也是可行的。

3.1.4法律可行性
这个系统与我国规定的各项中规章制度不产生冲突，该系统开发人员始终热爱祖国发，遵守法律法规，并且会严格禁止用户无视国家法律，与犯罪分子作斗争。其次这个系统是由个人独立完成的，绝不抄袭，侵犯版权。最后在收集用户信息等各种需要用户授权的情况都会询问用户意见，绝不违规操作。因此最后得知在法律可行性上也是可行的。



3.2需求分析
3.2.1需求概述 
为了开发出真正满足用户需求的社团管理系统，准确地回答“系统必须做什么”这个问题，因此对软件需求进行了深入研究，从而完成这个“成功”的社团管理系统。故经认真地思考，将系统的参与者定义为学生干事、社团管理者、社团领导（超级管理员）。并且将系统用例进行了分析，得出了以下的用例图。



图3-1  系统用例图




3.2.2学生干事功能分析
学生干事的主要功能如下：查看信息、签到会议、缴纳费用、提交报告，提交工作总结，填写策划等。
查看信息：主要用于查看个人信息，还有部门信息，例如部门简介，部门奖惩情况，方便用户了解信息。
签到会议：对于部长发布的会议进行签到打卡，无签到则视为缺席，用于开会点名，再也无需点人头了。
缴纳费用：对部门发布的缴费通知进行缴费，例如聚餐，外出游玩。 
提交报告：这是系统的主要功能，对每日工作的内容形成报表格式进行提交，省去了纸质打印的经费，还减少了人工统计的人力花销。
提交工作总结：干事们对每学期的工作进行汇报以及总结，提交至领导处审核，领导可根据这个查看干事的工作热情。
填写策划：可以发起策划，根据提示填写信息，从而一键生成策划，方便又好用，也无需但须字体样式等。



3.2.3部门干部功能分析
部门干部的主要功能如下：修改信息、发布会议、发布缴纳通知、管理部门人员、审查报告，审查工作总结等。
修改信息：修改部门宗旨，规章制度等。
发布会议：开会时发布会议，规定时间内签到，用于点名。
发布缴纳通知：管理部门财务工作。 
管理部门人员：纳新以及对态度不正的干事给予辞退。
审查报告：审查干事的工作内容，及时有效地了解干事的工作情况。
审查工作总结：同审查报告。






3.2.3部门领导功能分析
部门领导的主要功能如下：查看统计信息、审查策划、审查工作总结、管理部门人员，评选优秀干事干部、发布通知等。
查看统计信息：根据干事干部提交的工作内容，看看所统计出的信息，通过后台分析的数据，可直接看到统计信息。
审查策划：对干事们提交的策划进行查看，从而做出决定，批准或者进行退出。
审查工作总结：同理，对干事们的工作总结进行查看，从而了解部门的动向，从而有目的的去管理部门。
管理部门人员：对每年的部长任职等，管理部门人员。
评选优秀干事干部：每年对优秀的干部干事进行评选，授予奖励，从而调动干部干事的工作热情，使部门充满活力。
发布通知：对事情进行发布，从而更好的通知每个干事。
管理部门：对部门有效直接的管理，解散或者成立。
管理权限：授予不同角色不同的权限，从而根据不同的身份生成不同的菜单。


4 总体设计
4.1系统架构概述
本系统是在eclipse的开发环境下所开发的一个web项目。使用简单的设计架构模式（MVC）、数据模型（model）、用户界面（view）和控制器（controller）的模型：首先前端通过Ajax访问某个地址，被web过滤器拦截，从而进入后端所定义的控制器中执行某个功能模块的代码；接着在控制器中将前端所传入的参数进行分析处理，赋值给用户定义的数据模型或者直接使用，调用服务层，服务层调用DAO层。在DAO的xml文件中，编写sql语句，从而访问数据库，进行数据库操作，最后将返回结果层层返回，根据需求向前端返回一个新的用户界面或者是一段json格式的数据；最后前端再对后端所返回的对象进行渲染，跳转页面或者展现数据。该系统架构将前后端的代码分离，耦合度较小，适合小系统开发。

4.2系统功能图设计 
 根据上面3.2功能描述分析，将系统分成了以下的系统功能模块，如下图所示： 

图4-1 系统功能模块图
4.3系统业务流程设计
4.3.1业务流程概述
用户登入网站，先区分他们的身份，并分配不同的权限。部门的干事可以查看并修改自己的个人信息；并且查询是否有开会，对开会进行签到；当有缴费的需求时，可以进入缴费；最主要是可以对不同的部门生成不同的工作报告，干事可以填写并且提交今天的工作内容，填写策划，发起策划申请最后组织活动。干部主要对干事的工作报告进行审核，策划审核，审核通过送至领导处审核，不通过则退回。对部门人员进行纳新，辞退。发起会议，查看哪些人员未到场；领导则是对工作报告，工作总结的最后审核，不通过返回。并且评选优秀干部干事，对工作出色人员进行表彰。并且对校园的近况进行查看，查看迟到人员，晚归等违反校园规章制度的事情。

4.3.2业务流程图









 
		
图4-2  系统业务流程图


4.4数据库设计 
4.4.1数据库E-R图
图4-3 系统总体E-R图

1、学生班级信息ER图，一个学生只有一个班级，一个班级有多个学生，所以是一比多的关系。同理一个专业多个班级，一个班级只有一个专业、一个专业只由一名辅导员管理，一个辅导员可以管理多个专业.故他们也是一比多的关系。其中学生有家庭地址、年龄、生日、学号、邮箱、身份证、专业、姓名、政治面貌、籍贯、所在学校、性别、联系方式、民族等属性；班级有班级名称、班级总人数的属性；专业有专业名，专业总人数的属性。主要用于统计专业信息。

图4-4 学生班级信息E-R图
2、学生宿舍信息ER图，一个学生只住在一个宿舍中，一个宿舍有多个学生，所以是一比多的关系。同理一栋宿舍楼有多个宿舍，一个宿舍只在一栋宿舍楼中、一栋楼由多名楼管管理，一个楼管管理一栋宿舍楼.故他们也是一比多的关系。其中除了学生，宿舍有宿舍号，宿舍总人数的属性；楼栋只有编号的属性；楼管则有姓名、编号、联系方式的属性。这些表主要用来统计宿舍的信息，进行评比等。

图4-5 学生宿舍信息E-R图
3、部门干事信息ER图，一个学生可以成为多个部门的干事，部门可以容纳多个干事，干事只有一个学生的身份，学生加入了部门才可以称之为干事。因此学生和干事是一比多的关系，干事和部门为一比多的关系。其中干事同属于用户，他有账号、密码、头像、状态、和学生的属性；部门则有他的信息，如部门姓名、部门简介、部门职责、部门性质、领导组织、成立时间等等属性。

图4-6  部门干事信息E-R图
4、用户角色权限信息ER图，一个用户可以成为多种角色，一种角色包含多个人、一种角色可以有多种权限，一种权限能够被多种角色拥有。因此他们是多对多的关系。

图4-7  用户角色权限信息E-R图
5、干事文档信息ER图，一个干事可以提交多份文档，一份只能由一个人提交。因此他们是一对多的关系。

图4-8  干事文档信息ER图E-R图

4.4.2系统数据表
表4-1  班级信息表  ( cm_class)
Code	Data Type	Length	Comment	Primary
id	bigint			√
major_id	bigint		专业	
name	varchar(50)	50	班级名称	
num	int		班级人数	

表4-2  专业信息表  ( cm_major)
Code	Data Type	Length	Comment	Primary
id	bigint			√
instructor_id	varchar(40)	40	辅导员	
name	varchar(50)	50	专业名称	
num	int		专业总人数	

表4-3  辅导员表  ( cm_instructor)
Code	Data Type	Length	Comment	Primary
address	varchar(100)	100	家庭地址	
birthday	datetime		生日	
code	varchar(15)	15	编号	
content	varchar(500)	500	备注	
id	int			√
id_card	varchar(18)	18	身份证号	
name	varchar(50)	50	姓名	
political	varchar(20)	20	政治面貌	
roots	varchar(30)	30	籍贯	
sex	varchar(10)	10	性别	
tel	varchar(15)	15	联系方式	
volk	varchar(10)	10	民族	

表4-4  房间信息表  ( cm_room)
Code	Data Type	Length	Comment	Primary
house	bigint		楼栋号	
id	bigint			√
name	varchar(5)	5	房间号	
num	int		房间人员数	

表4-5  楼栋信息表  ( cm_house)
Code	Data Type	Length	Comment	Primary
id	bigint			√
name	int		楼栋名称	



表4-6  楼栋信息表  ( cm_house_master)
Code	Data Type	Length	Comment	Primary
code	varchar(20)	20	编号	
house	bigint		管理楼栋	
id	bigint			√
name	varchar(30)	30	楼管名字	
tel	varchar(20)	20	楼管联系方式	

表4-7  用户信息表  ( cm_user)
Code	Data Type	Length	Comment	Primary
account	varchar(20)	20	账号	
avatar	varchar(500)	500	头像	
creat_time	varchar(20)	20	创建时间	
department_id	varchar(40)	40	所属部门	
id	varchar(40)	40		√
password	varchar(50)	50	密码	
role	bigint		角色	
state	varchar(20)	20	状态	
student_id	varchar(40)	40	学生信息	
tel	varchar(20)	20	电话	
username	varchar(20)	20	名字	

表4-8  部门信息表  ( cm_department)
Code	Data Type	Length	Comment	Primary
characters	varchar(100)	100	部门性质	
droit	varchar(1000)	1,000	权利	
duty	varchar(200)	200	部门职责	
general_rules	varchar(1000)	1,000	总则	
id	varchar(40)	40		√
info	varchar(200)	200	部门信息	
lead_organize	varchar(50)	50	领导组织	
master_name	varchar(50)	50	负责人姓名	
master_tel	varchar(20)	20	负责人电话	
name	varchar(50)	50	部门名称	
num	int		部门总人数	
obligation	varchar(1000)	1,000	义务	
other	varchar(1000)	1,000	其他	
purpose	varchar(500)	500	宗旨	
registration_name	varchar(50)	50	创始人	
registration_time	varchar(30)	30	成立时间	
requirement	varchar(1000)	1,000	要求	



表4-9  学生信息表  ( cm_student)
Code	Data Type	Length	Comment	Primary
address	varchar(100)	100	家庭地址	
age	int		年龄	
bed	int		床位	
birthday	datetime		生日	
class	varchar(10)	10	班级	
code	varchar(15)	15	学号	
content	varchar(500)	500	备注	
email	varchar(50)	50	邮箱	
grade	varchar(10)	10	年级	
house	bigint		楼号	
id	varchar(40)	40		√
id_card	varchar(18)	18	身份证号	
major	varchar(50)	50	专业	
name	varchar(50)	50	姓名	
parent_name1	varchar(50)	50	监护人1	
parent_name2	varchar(50)	50	监护人2	
parent_tel	varchar(15)	15	监护人联系方式	
political	varchar(20)	20	政治面貌	
room	bigint		宿舍号	
roots	varchar(30)	30	籍贯	
school	varchar(50)	50	所在学校	
sex	varchar(10)	10	性别	
tel	varchar(15)	15	联系方式	
volk	varchar(10)	10	民族	

表4-10  用户角色关联表  ( cm_user_role_ref)
Code	Data Type	Length	Comment	Primary
id	bigint			√
role_id	bigint		角色	
user_id	varchar(40)	40	用户	

表4-11  角色信息表  ( cm_role)
Code	Data Type	Length	Comment	Primary
id	bigint			√
name	varchar(50)	50	角色名	
power	bigint		权限	

表4-12  角色权限关联表  ( cm_role_power_ref)
Code	Data Type	Length	Comment	Primary
id	bigint			√
power_id	varchar(40)	40		
role_id	bigint			

表4-13  权限表  ( cm_power)
Code	Data Type	Length	Comment	Primary
content	varchar(100)	100	内容	
id	varchar(40)	40		√
name	varchar(50)	50	权限名称	
parent_id	varchar(40)	40	上一级权限	
soft	varchar(40)	40	权限类型	


表4-14  申请加入部门信息表  ( cm_department_apply)
Code	Data Type	Length	Comment	Primary
apply_id	varchar(50)	50	申请人id	
apply_name	varchar(50)	50	申请人名字	
creat_time	datetime		创建时间	
department	varchar(40)	40	所属部门	
id	bigint			√
state	varchar(40)	40	状态	


表4-15  签到活动表（cm_attendance）
Code	Data Type	Length	Comment	Primary
begin_time	datetime		签到开始时间	
creat_time	datetime		签到创建时间	
department_id	varchar(40)	40	所属部门	
end_time	datetime		签到结束时间	
id	bigint			√
name	varchar(100)	100	签到事件名称	
state	varchar(40)	40	状态	
user_name	varchar(40)	40	发起人	


表4-16  签到记录表  ( cm_attendance_record)
Code	Data Type	Length	Comment	Primary
attendance_id	bigint		活动id	
department_id	varchar(40)	40	所属部门	
id	bigint			√
sign_time	datetime		签到时间	
state	varchar(20)	20	状态	
user_name	varchar(40)	40	发起人	




表4-17  部门优秀评比表  ( cm_department_rating)
Code	Data Type	Length	Comment	Primary
content	varchar(1000)	1,000	内容	
creat_time	datetime		评比时间	
department_id	varchar(40)	40	所属部门	
department_name	varchar(50)	50	部门名称	
id	bigint			√
name	varchar(100)	100	报告名称	
state	varchar(40)	40	状态	
title	varchar(100)	100	标题	
user_name	varchar(40)	40	所属人	


表4-18  部门经费收缴表  ( cm_payment)
Code	Data Type	Length	Comment	Primary
creat_time	datetime		缴费创建时间	
department_id	varchar(40)	40	所属部门	
id	bigint			√
name	varchar(100)	100	缴费原因	
state	varchar(40)	40	状态	
user_name	varchar(40)	40	发起人	


表4-19  缴费记录表  ( cm_payment_record)
Code	Data Type	Length	Comment	Primary
department_id	varchar(40)	40	所属部门	
id	bigint			√
pay_time	datetime		付款时间	
payment_id	bigint		活动id	
state	varchar(20)	20	状态	
user_name	varchar(40)	40	发起人	

表4-20  工作总结表  ( cm_work_summary)
Code	Data Type	Length	Comment	Primary
content	varchar(1000)	1,000	内容	
creat_time	datetime		报告创建时间	
department_id	varchar(40)	40	所属部门	
id	bigint			√
name	varchar(100)	100	报告名称	
state	varchar(40)	40	状态	
title	varchar(100)	100	标题	
user_name	varchar(40)	40	发起人	


表4-21  策划信息表  ( cm_scheme)
Code	Data Type	Length	Comment	Primary
arrangements	varchar(1000)	1,000	活动人员安排	
award	varchar(1000)	1,000	奖励	
begin_time	varchar(100)	100	活动时间	
budget	varchar(1000)	1,000	资金预算	
code	varchar(15)	15	编号	
content	varchar(1000)	1,000	活动内容	
creat_person	varchar(50)	50	创建人	
creat_time	datetime		创建时间	
department	varchar(40)	40	所属部门	
description	varchar(1000)	1,000	活动说明	
flow	varchar(1000)	1,000	活动流程	
form	varchar(150)	150	活动形式	
goal	varchar(250)	250	活动目的	
id	bigint			√
name	varchar(100)	100	活动名称	
person	varchar(150)	150	活动人员	
place	varchar(100)	100	活动地点	
state	varchar(40)	40	状态	
theme	varchar(200)	200	活动主题	


表4-22  字典表  ( cm_dict)
Code	Data Type	Length	Comment	Primary
code	varchar(50)	50	编号	
content	varchar(100)	100	说明	
id	bigint			√
name	varchar(50)	50	姓名	
parent_id	bigint		父节点	
type	varchar(50)	50	类型	
value	varchar(50)	50	字典值	


5 详细设计与实现
本章节将对各个系统参与者的主要模块的具体实现进行叙述。 其中，普通干事有四个主要模块：签到会议、提交工作报告、提交工作总结、填写策划。干部有发布会议，管理部门人员，审查工作报告，审查工作总结这四个主要模块。部门领导有查看统计信息，审查报告，优秀干部干事评比，管理部门这四个主要模块。这些模块的详细分析下文将会一一介绍。

5.1干事功能详细设计
5.1.1 查看及修改个人信息
每个干事有自己的个人信息，他们可以修改自己的头像以及账号密码等，修改密码则会验证手机号是否为本人操作，本系统使用腾讯云的短信服务系统，调用他们的借口向用户发送验证码，在规定时间能输入正确的验证码，通过验证则可以修改密码。

图5-1  个人信息界面

图5-2  修改密码界面
向手机发送验证码的代码如下：

图5-3  验证码代码
5.1.2 会议签到
会议签到模块用于用户进入这个页面之后可以查询自己有关的时间会议，然后进入会议进行签到，未在规定时间内则无法签到，视为未到。

图5-4  签到流程图





图5-5  进入签到界面

图5-6  签到界面
5.1.3 缴纳费用
缴纳费用模块能够让用户可以查看部长是否有发起缴费申请，例如聚会交钱的活动，部门需要向用户收取费用，用户可以通过这个功能进入缴费。

图5-7 用户缴费界面
5.1.4 提交工作报告
提交工作报告模块用户的主要功能之一，不同用户进入后系统将会加载属于他部门的报告，例如自律会会加载上课点名表、宿舍晚归表、卫生检查表等等；学生会会加载赞助结果表等；校卫队则加载消防检查表，巡逻记录表等。系统根据不同的角色来创建表格样式。用户填写提交后便会到部长那进行审查。


图5-8 提交工作报告流程图

图5-9 提交工作报告界面
5.1.5 提交工作总结
提交工作总结模块也是主要模块之一，在每个学期或者没过一个时间段，有些部门可能会让干事写工作报告。现在工作报告也可以在该系统写了，里面有工作报告标题，内容，署名，时间。用户可以进行填写直接递交到领导处，由领导进行检查。

图5-10 提交工作总结流程图

图5-11 提交工作总结界面
5.1.6 填写策划
在这个模块，用户可以直接通过本系统进行策划申请，需要填写活动人员安排、奖励、活动时间、资金预算、活动内容、、所属部门、活动说明、活动流程、活动形式、活动目的、活动名称、活动人员、活动地点、活动主题就可以一键生成策划样式的文档。生成提交后给部长进行审核。减少了用户的工作量，方便用户生成策划，相比以前写work文档省事省力。
填写策划的界面样式如下图：

图5-12 策划填写界面
	生成后的策划样式如下图：

图5-13 生成策划样式
模块流程图：

图5-14 编辑策划流程图
5.2部门干部功能详细设计
5.2.1 部门干部首页

图5-15 部长首页
5.2.2 修改部门信息
这个模块用来让部门干部可以修改部门信息，这些信息会直接显示给其他用户，部门干部可以根据这些信息来吸引纳新。

图5-16 部门信息界面
5.2.3 发布会议
发布会议模块能让部门干部在开会前发布会议，根据会议开始时间，结束时间来确认是否有人缺席。这样就可以省去点名时间。

图5-17 会议信息填写界面

图5-18 签到状态界面
5.2.4 管理干事
部门干部在纳新及辞退干事时可以使用该模块，可以查看申请加入部门的人员以及辞退干事。被辞退的干事将无法使用该部门拥有的权限，加入的干事则可以享受该部门的权限。

图5-19 查看申请人员界面

图5-20 辞退人员界面
被同意加入的用户进入系统将会收到以下提示：

图5-21 查看申请人员界面
被辞退的干事进入系统将会收到以下提示：

图5-22 查看申请人员界面
5.2.5 审查工作报告
这是主要模块之一，部门干部有权对其部门的干事工作报告进行审查，审查通过后将会送至领导处。

图5-23 查看工作报告界面
5.2.6审查工作总结
这个模块用于部门干部对其部门干事的工作总结进行评审，如果不通过将会重新返回用户进行重写提交，部门干部再次审核，直至通过。


图5-24 查看工作总结界面
5.3领导功能详细设计
5.3.1 部门领导首页

图5-25 领导首页
5.3.2 查看统计信息
这个模块将会根据每个干事所提交的工作报告生成首页，从而查看学校近况和干事的工作状态。

图5-26 详细统计信息
5.3.3 审查策划
这个模块将是策划管理的最后一个步骤，决定一个策划能否的的到领导的批准，从而举办，申请物资。这是系统的主要功能之一。

图5-27 策划详情界面
5.3.4 审查工作总结
这个模块是系统的主要模块之一，用于领导查看某一时间段内干事的工作态度工作感言，倾听干事的心声，是社团管理系统的重要组成部分。所有干事的工作总结都将会到领导这里审核。

图5-28 查看工作总结界面
5.3.5 发布通知
发布通知模块是专门将消息传递给用户，让用户明了的明白上级的指令，避免口口相传的消息被误解以及最快的通知到每一个干事。

图5-29 发布通知界面
5.3.5 评选优秀干部干事
评比模块是为了把现实中的拼比放到了系统中，有记录的将优秀人员的奖励情况记录在系统中。

图5-30 评比界面
5.3.5管理部门人员
这个模块主要让领导能对部长进行任免，进行部长换届或者临时更换部长。

图5-31 部长管理界面
5.3.5 管理权限
权限模块是专门领导将可以对部长等进行分配权限，设立部长的权利范围，让系统健康发展。

图5-32 角色权限界面
5.3.5 管理部门
领导有权可以增加部门或者解散部门，管理部门模块是对部门进行统一管理，解散无用部门，设立新的部门。

图5-33 查看部门信息界面

图5-34 新增部门界面

6 软件测试
6.1 软件测试的目的 
软件测试是伴随软件产品的诞生而产生，按照测试方案和流程对软件产品进行功能以及非功能性测试，并且对测试方案可能出现的问题进行分析和评估，找出文档数据程序中的偏差，保证程序稳定正常的按照理想状态运行。
6.2 软件测试方案
该系统的测试策略包含用户界面测试，功能测试，安全测试和结构测试。界面测试主要测试每个按钮，字体等是否正常显示，页面名称等名字是否保持一致；功能测试覆盖系统全部功能；安全测试包括密码安全，权限安全等跨级操作；结构测试使用白盒测试，对主要模块重点模块进行测试，检验是否按照逻辑进行。
测试环境：
电脑型号  惠普 HP
操作系统  Microsoft Windows 7 旗舰版  (64位/Service Pack 1)
CPU  (英特尔)Intel(R) Core(TM) i7-4500U CPU @ 1.80GHz(2401 MHz)
主板  惠普 2166
内存  8.00 GB (1600 MHz)
主硬盘  1000 GB (希捷 ST1000LM 048-2E7172 SCSI Disk Device)
显卡  Intel(R) HD Graphics Family (2112 MB)

6.3 软件测试结论
通过反复认真的测试，可以得出以下结论：
(1)在界面测试中，所有界面均与预期一致，用户体验较为良好。因此界面测试基本通过。
(2)在功能测试中，所有功能都能够按预期执行，并未发现无法使用的功能，因此功能测试基本通过。
(3)在安全测试中，使用不同角色访问其他角色权限均无法正常访问，未登录无法执行登录后才能使用的权限，因此安全测试也基本通过。
在结构测试中，系统的主要模块与重点模块均能得到正确的输出，可以得出逻辑基本正确，因此结构测试也基本通过。
建议：
(1)可以增加消息提示来增强用户体验，避免用户输错而导致错误。
(2)在代码中部分逻辑可以进行改进，减少代码量与程序复杂度，多加注释。
总结论：本次测试通过，可以进行下一阶段内容,在升级版本中，考虑参照建议，优化项目。

7 结语
本文研究了一种基于SSM框架开发的社团管理系统，包括了正常软件开发的过程中的基本流程，后端则使用了SSM的框架，前端使用LayUI的框架以及ECharts，结合了mysql的数据库。可以通过访问电脑浏览器和手机浏览器，进行使用该系统。通过从身边发现问题，提出系统概念，详细的分析，设计等步骤可以得出以下问题、结论以及未来方向：
（1）现在大学越来越重视精神文化的培养，教导学生要德智体美劳全面发展。拿福建工程学院而言，“三个文明”的建设一直都是十分重要的建设工程。而在这个过程中，社团的日常工作便是“三个文明”建设发展的基础保障。然而社团活动的工作流程是如何的？这个问题值得我们深思。是领导与部门之间口语相传？那么凭据是什么？因此这些问题也是我们需要去解决的问题。
（2）这个系统在大学十分重要，经过前期的调查，这个系统在校园中有着不错的人气与期望值。由于其他社团管理系统的功能并不完全，而且只有一些简单的部门管理，例如人员管理。因此现有的其它社团管理系统并不能充分发挥它的便利之处，这也是这些系统一直未被投放使用的原因。这使得这个版本的系统的优势突显出来，可视化的数据分析，方便的查找到上课迟到或者晚归的信息等等。同比其它版本，这个的存在价值更高，值得投入使用。
（3）由于时间仓促，本应功能庞大的功能被简化，留下了好用的功能；在设计中仍然考虑的不够周全，存在这一些逻辑存在漏洞的功能；还有未和辅导员楼管及学校领导紧密绑定一起，只是简单分析一些数据。希望在以后的版本中能够在社团中发现问题后能够及时通知相关人员以及显示，充分避免数据的实效性，及时分析，从而更加完善这个系统，让其在很长一段时间无法替代以及大范围的投入使用。
总的来说，现如今的情形下，该系统还是能够被小范围使用，并且这个系统简单，代码结构易懂，能够进行二次开发，在一期的基础上，对一期的版本进行升级，从而更好的满足用户需求。

8 致谢
时光飞逝，转眼半年已经过去。似乎很快，却也似乎十分漫长，在这半年的时间里我学会了很多。当然这得多亏我的导师，老师，同学，朋友还有公司的同事。我想在这半年里，对于我是一次质的飞跃，华丽的蜕变。通过这一份平凡却也不简单的毕业设计，让我迅速成长。感谢你们！
首先得感谢我的指导老师*教授，本文是在*导师的指导下完成的，是他在我捉摸不到头脑的时候，用他高远的眼光指导我，让我看到了不一样的解决方式，甚至更优。感谢您，我的导师，谢谢您从不厌烦地用您措置裕如的经验让我解决无数困难险阻；谢谢您在我快走偏的时候用您独特的见解指引我，带我走出迷雾。感谢您，我的导师，我的大学因为您而画上完美的句号。
其次，我还要感谢那些所有教过我的老师，你们教会了我非常多的知识，更重要的是还教会了我如何学习，从而在今后不在学校的日子能够自己吸取养分，甚至让我明白，只有读书才能让自己充实，只有不断读书再能更理解这个世界。谢谢你们。
最后还要感谢我的室友们，朋友们，以及同事们。从他们哪里我也学会很多技能、方法，在同他们交流中，我收获了很多不同的见解，不同的视角，一个自己的盲区从别人严中口中发现。感谢我的伙伴们，能够给我讲解什么原因引起的bug以及告诉我思路中的漏洞，让我能够考虑周全，也让我的思维更加广阔。他们让我知道无论是代码还是人生，总有无数种视角,不光光是一种解题方法。感谢你们，让我学会了很多的人生道理。
最后，向参加毕业论文评审的老师表示真挚谢意，谢谢你们，你们辛苦了，还望你们多多指教。在未来的日子里，我定会不负众望，继续努力，让我的人生绽放更美丽的烟火。

9 参考文献
[1]刘欢,李功权.基于WebGIS的校园社团管理系统[J].地理空间信息,2018,16(3):68-70. DOI:10.3969/j.issn.1672-4623.2018.03.020.
[2]王钢,李曦.高校艺术社团建设与校园文化管理[J].艺术品鉴,2018,000 (015):P.250-251.
[4]许一帆.浅析校园学生社团管理[J].卷宗,2017,(7):91-91,92.
[5]许永华.中等职业学校校园社团管理系统管理系统分析与设计[D].云南:云南大学,2014. 
[6]骆龙飞.基于Oracle BIEE图表展示与ECharts结合的优化研究[J].信息技术与信息化,2017,(11):108-110. DOI:10.3969/j.issn.1672-9528.2017.11.031.
[7]乔岚.基于MyBatis和Spring的JavaEE数据持久层的研究与应用[J].信息与电脑,2017,(8):73-76. DOI:10.3969/j.issn.1003-9767.2017.08.028.
[8]杨晶洁.基于Spring+Struts2+Mybatis架构的设备状况管理系统的设计[J].电脑迷,2017,(6):112-113. DOI:10.3969/j.issn.1672-528X.2017.06.095.
[9]罗迪,云龙,杨姣.基于Spring+MyBatis的高校人事管理系统的设计与实现[J].数字技术与应用,2017,(4):179. DOI:10.3969/j.issn.1007-9416.2017.04.112.
[10]乔岚.基于MyBatis和Spring的JavaEE数据持久层的研究与应用[J].信息与电脑(理论版),2017,(008):73-76.
[11]阳小兰,罗明.基于Spring+SpringMVC+MyBatis网上论坛的设计与实现[J].黑龙江科技信息,2016,(36):279-280. DOI:10.3969/j.issn.1673-1328.2016.36.249.
[12]张惜杰,李平,张志强, 等.基于ECharts与ArcGIS JavaScript API的Web专题制图研究[J].测绘,2017,40(6):270-273. DOI:10.3969/j.issn.1674-5019.2017.06.009.
[13]冯娟,张雅丽,梁栋栋.基于Echarts的居民出游时空可视化研究——以芜湖市为例[J].电脑知识与技术,2017,13(31):215-218.
[14]冀潇,李杨.采用ECharts可视化技术实现的数据体系监控系统[J].计算机系统应用,2017,26(6):72-76. DOI:10.15888/j.cnki.csa.005782.
[15]平安科技（深圳）有限公司.基于eCharts工具的图表制作方法、装置、设备及介质:中国,CN201711291906.3[P].2018-06-29