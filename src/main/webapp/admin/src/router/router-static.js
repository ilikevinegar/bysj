import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import bumenlingdao from '@/views/modules/bumenlingdao/list'
    import yuangong from '@/views/modules/yuangong/list'
    import yuangonggongzi from '@/views/modules/yuangonggongzi/list'
    import lingdaogongzi from '@/views/modules/lingdaogongzi/list'
    import gongzuorenwu from '@/views/modules/gongzuorenwu/list'
    import lingdaojixiaokaohe from '@/views/modules/lingdaojixiaokaohe/list'
    import menu from '@/views/modules/menu/list'
    import gongzuojilu from '@/views/modules/gongzuojilu/list'
    import renshidiaodong from '@/views/modules/renshidiaodong/list'
    import bumen from '@/views/modules/bumen/list'
    import hetongxinxi from '@/views/modules/hetongxinxi/list'
    import zhiwei from '@/views/modules/zhiwei/list'
    import gongzuojinsheng from '@/views/modules/gongzuojinsheng/list'
    import gonggaoxinxi from '@/views/modules/gonggaoxinxi/list'
    import yuangongshiwu from '@/views/modules/yuangongshiwu/list'
    import yuangongjixiaokaohe from '@/views/modules/yuangongjixiaokaohe/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/bumenlingdao',
        name: '部门领导',
        component: bumenlingdao
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/gongzuorenwu',
        name: '工作任务',
        component: gongzuorenwu
      }
      ,{
	path: '/lingdaojixiaokaohe',
        name: '领导绩效考核',
        component: lingdaojixiaokaohe
      }
      ,{
	path: '/menu',
        name: '菜单列表',
        component: menu
      }
      ,{
	path: '/gongzuojilu',
        name: '工作记录',
        component: gongzuojilu
      }
      ,{
	path: '/bumen',
        name: '部门',
        component: bumen
      }
      ,{
	path: '/hetongxinxi',
        name: '合同信息',
        component: hetongxinxi
      }
      ,{
	path: '/zhiwei',
        name: '职位',
        component: zhiwei
      }
      ,{
	path: '/gonggaoxinxi',
        name: '公告信息',
        component: gonggaoxinxi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
