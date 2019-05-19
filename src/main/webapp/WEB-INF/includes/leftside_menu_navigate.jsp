<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${admin.aname}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">管理菜单 | Management</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/userlist" target="admin"><i class="fa fa-circle-o"></i>用户列表</a></li>
                    <li><a href="/admin/userform" target="admin"><i class="fa fa-circle-o"></i>用户新增</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>景点管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/viewlist" target="admin"><i class="fa fa-circle-o"></i>景点列表</a></li>
                    <li><a href="/admin/viewedit" target="admin"><i class="fa fa-circle-o"></i>景点新增</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-hotel"></i> <span>酒店管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/hotellist" target="admin"><i class="fa fa-circle-o"></i>酒店列表</a></li>
                    <li><a href="/admin/hotelInsertForm" target="admin"><i class="fa fa-circle-o"></i>酒店新增</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-forumbee"></i> <span>论坛管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/forumList" target="admin"><i class="fa fa-circle-o"></i>帖子列表</a></li>
                    <li><a href="/admin/forumInsertForm" target="admin"><i class="fa fa-circle-o"></i>帖子新增</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-sticky-note"></i> <span>评论管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/wordsList" target="admin"><i class="fa fa-circle-o"></i>评论列表</a></li>
                    <li><a href="/admin/replyList" target="admin"><i class="fa fa-circle-o"></i>回复列表</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-car"></i> <span>交通管理</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/trafficList" target="admin"><i class="fa fa-circle-o"></i>交通列表</a></li>
                    <li><a href="/admin/trafficInsert" target="admin"><i class="fa fa-circle-o"></i>交通新增</a></li>
                </ul>
            </li>

        </ul>
    </section>
</aside>