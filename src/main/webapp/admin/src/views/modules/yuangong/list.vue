<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                <el-form-item :label="contents.inputTitle == 1 ? '员工工号' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.yuangonggonghao" placeholder="员工工号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.yuangonggonghao" placeholder="员工工号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.yuangonggonghao" placeholder="员工工号" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '员工姓名' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.yuangongxingming" placeholder="员工姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.yuangongxingming" placeholder="员工姓名" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.yuangongxingming" placeholder="员工姓名" clearable></el-input>
                </el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>
            <el-button
              v-if="isAuth('yuangong','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-plus"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('yuangong','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}<i class="el-icon-plus el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('yuangong','新增') && contents.btnAdAllIcon == 0"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('yuangong','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              icon="el-icon-delete"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>
            <el-button
              v-if="isAuth('yuangong','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('yuangong','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>




            <el-button
              v-if="isAuth('yuangong','报表') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="warning"
              icon="el-icon-s-data"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}</el-button>
            <el-button
              v-if="isAuth('yuangong','报表') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="warning"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}<i class="el-icon-s-data el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('yuangong','报表') && contents.btnAdAllIcon == 0"
              type="warning"
              @click="chartDialog()"
            >{{ contents.btnAdAllFont == 1?'统计报表':'' }}</el-button>

          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('yuangong','查看')"
            :data="dataList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                :header-align="contents.tableAlign"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" :align="contents.tableAlign"  v-if="contents.tableIndex" type="index" width="50" />
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="yuangonggonghao"
                   :header-align="contents.tableAlign"
		    label="员工工号">
		     <template slot-scope="scope">
                       {{scope.row.yuangonggonghao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="yuangongxingming"
                   :header-align="contents.tableAlign"
		    label="员工姓名">
		     <template slot-scope="scope">
                       {{scope.row.yuangongxingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="xingbie"
                   :header-align="contents.tableAlign"
		    label="性别">
		     <template slot-scope="scope">
                       {{scope.row.xingbie}}
                     </template>
                </el-table-column>
                  <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign"  prop="touxiang"
                   :header-align="contents.tableAlign"
                    width="200"
                    label="头像">
                    <template slot-scope="scope">
                      <div v-if="scope.row.touxiang">
                        <img :src="$base.url+scope.row.touxiang.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="renyuan"
                   :header-align="contents.tableAlign"
		    label="人员">
		     <template slot-scope="scope">
                       {{scope.row.renyuan}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="zhiwei"
                   :header-align="contents.tableAlign"
		    label="职位">
		     <template slot-scope="scope">
                       {{scope.row.zhiwei}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="shouji"
                   :header-align="contents.tableAlign"
		    label="手机">
		     <template slot-scope="scope">
                       {{scope.row.shouji}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="dizhi"
                   :header-align="contents.tableAlign"
		    label="地址">
		     <template slot-scope="scope">
                       {{scope.row.dizhi}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="jiaoyujingli"
                   :header-align="contents.tableAlign"
		    label="教育经历">
		     <template slot-scope="scope">
                       {{scope.row.jiaoyujingli}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="gongzuojingli"
                   :header-align="contents.tableAlign"
		    label="工作经历">
		     <template slot-scope="scope">
                       {{scope.row.gongzuojingli}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="jiatingbeijing"
                   :header-align="contents.tableAlign"
		    label="家庭背景">
		     <template slot-scope="scope">
                       {{scope.row.jiatingbeijing}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="peixunjingli"
                   :header-align="contents.tableAlign"
		    label="培训经历">
		     <template slot-scope="scope">
                       {{scope.row.peixunjingli}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="yuyannengli"
                   :header-align="contents.tableAlign"
		    label="语言能力">
		     <template slot-scope="scope">
                       {{scope.row.yuyannengli}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="gerenzhicheng"
                   :header-align="contents.tableAlign"
		    label="个人职称">
		     <template slot-scope="scope">
                       {{scope.row.gerenzhicheng}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="lingdaozhanghao"
                   :header-align="contents.tableAlign"
		    label="领导账号">
		     <template slot-scope="scope">
                       {{scope.row.lingdaozhanghao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="lingdaoxingming"
                   :header-align="contents.tableAlign"
		    label="领导姓名">
		     <template slot-scope="scope">
                       {{scope.row.lingdaoxingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign" 
                    prop="bumen"
                   :header-align="contents.tableAlign"
		    label="部门">
		     <template slot-scope="scope">
                       {{scope.row.bumen}}
                     </template>
                </el-table-column>
            <el-table-column width="300" :align="contents.tableAlign" 
               :header-align="contents.tableAlign"
                label="操作">
                <template slot-scope="scope">
                <el-button v-if="isAuth('yuangong','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','查看') && contents.tableBtnIcon == 0" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','晋升') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="gongzuojinshengCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'晋升':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','晋升') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="gongzuojinshengCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'晋升':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','晋升') && contents.tableBtnIcon == 0" type="success" size="mini" @click="gongzuojinshengCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'晋升':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','绩效考核') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="yuangongjixiaokaoheCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'绩效考核':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','绩效考核') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="yuangongjixiaokaoheCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'绩效考核':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','绩效考核') && contents.tableBtnIcon == 0" type="success" size="mini" @click="yuangongjixiaokaoheCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'绩效考核':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','发布工作') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="gongzuorenwuCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'发布工作':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','发布工作') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="gongzuorenwuCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'发布工作':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','发布工作') && contents.tableBtnIcon == 0" type="success" size="mini" @click="gongzuorenwuCrossAddOrUpdateHandler(scope.row,'cross','','','')">{{ contents.tableBtnFont == 1?'发布工作':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('yuangong','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('yuangong','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('yuangong','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

    <gongzuojinsheng-cross-add-or-update v-if="gongzuojinshengCrossAddOrUpdateFlag" :parent="this" ref="gongzuojinshengCrossaddOrUpdate"></gongzuojinsheng-cross-add-or-update>
    <renshidiaodong-cross-add-or-update v-if="renshidiaodongCrossAddOrUpdateFlag" :parent="this" ref="renshidiaodongCrossaddOrUpdate"></renshidiaodong-cross-add-or-update>
    <yuangongjixiaokaohe-cross-add-or-update v-if="yuangongjixiaokaoheCrossAddOrUpdateFlag" :parent="this" ref="yuangongjixiaokaoheCrossaddOrUpdate"></yuangongjixiaokaohe-cross-add-or-update>
    <gongzuorenwu-cross-add-or-update v-if="gongzuorenwuCrossAddOrUpdateFlag" :parent="this" ref="gongzuorenwuCrossaddOrUpdate"></gongzuorenwu-cross-add-or-update>




    <el-dialog
      title="统计报表"
      :visible.sync="chartVisiable"
      width="800">
        <div id="renyuanChart" style="width:100%;height:600px;"></div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="chartDialog">返回</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import gongzuojinshengCrossAddOrUpdate from "../gongzuojinsheng/add-or-update";
import renshidiaodongCrossAddOrUpdate from "../renshidiaodong/add-or-update";
import yuangongjixiaokaoheCrossAddOrUpdate from "../yuangongjixiaokaohe/add-or-update";
import gongzuorenwuCrossAddOrUpdate from "../gongzuorenwu/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
      gongzuojinshengCrossAddOrUpdateFlag: false,
      renshidiaodongCrossAddOrUpdateFlag: false,
      yuangongjixiaokaoheCrossAddOrUpdateFlag: false,
      gongzuorenwuCrossAddOrUpdateFlag: false,
      contents:{"searchBtnFontColor":"rgba(255, 255, 255, 1)","pagePosition":"2","inputFontSize":"14px","inputBorderRadius":"20px","tableBtnDelFontColor":"rgba(255, 255, 255, 1)","tableBtnIconPosition":"1","searchBtnHeight":"40px","tableBgColor":"#f5f5f5","inputIconColor":"rgba(255, 255, 255, 1)","searchBtnBorderRadius":"20px","tableStripe":false,"btnAdAllWarnFontColor":"rgba(36, 139, 146, 1)","tableBtnDelBgColor":"rgba(36, 139, 146, 1)","searchBtnIcon":"1","tableSize":"medium","searchBtnBorderStyle":"solid","text":{"padding":"0px","boxShadow":"0px 0px 0px 0px  rgba(142, 209, 214, 1)","margin":"10px auto","borderColor":"rgba(255, 255, 255, 1)","backgroundColor":"rgba(144, 238, 144, 0)","color":"rgba(36, 139, 146, 1)","borderRadius":"0","borderWidth":"0","width":"auto","lineHeight":"200px","fontSize":"30px","borderStyle":"double"},"tableSelection":true,"searchBtnBorderWidth":"5px","tableContentFontSize":"14px","searchBtnBgColor":"rgba(36, 139, 146, 1)","inputTitleSize":"14px","btnAdAllBorderColor":"#DCDFE6","pageJumper":false,"btnAdAllIconPosition":"1","searchBoxPosition":"2","tableBtnDetailFontColor":"rgba(255, 255, 255, 1)","tableBtnHeight":"35px","pagePager":true,"searchBtnBorderColor":"rgba(220, 223, 230, 1)","tableHeaderFontColor":"rgba(0, 0, 0, 1)","inputTitle":"1","tableBtnBorderRadius":"10px 0px 10px 0px","btnAdAllFont":"1","btnAdAllDelFontColor":"rgba(36, 139, 146, 1)","tableBtnIcon":"0","btnAdAllHeight":"40px","btnAdAllWarnBgColor":"rgba(36, 139, 146, 0)","btnAdAllBorderWidth":"0","tableStripeFontColor":"rgba(0, 0, 0, 1)","tableBtnBorderStyle":"solid","inputHeight":"40px","btnAdAllBorderRadius":"0","btnAdAllDelBgColor":"rgba(36, 139, 146, 0)","pagePrevNext":true,"btnAdAllAddBgColor":"rgba(36, 139, 146, 0)","searchBtnFont":"1","tableIndex":true,"btnAdAllIcon":"1","tableSortable":false,"pageSizes":false,"tableFit":true,"pageBtnBG":false,"searchBtnFontSize":"14px","tableBtnEditBgColor":"rgba(36, 139, 146, 1)","box":{"padding":"10px 20px","boxShadow":"0 0 6px rgba(0,0,0,0)","flag":"1","backgroundImage":"http://codegen.caihongy.cn/20211124/873782b96c3543ceb98920965ce530c9.jpg","background":"rgba(142, 209, 214, 0.4)"},"inputBorderWidth":"5px","inputFontPosition":"1","inputFontColor":"rgba(255, 255, 255, 1)","pageEachNum":10,"tableHeaderBgColor":"rgba(142, 209, 214, 1)","inputTitleColor":"rgba(0, 0, 0, 1)","btnAdAllBoxPosition":"1","tableBtnDetailBgColor":"rgba(36, 139, 146, 1)","inputIcon":"0","searchBtnIconPosition":"1","btnAdAllFontSize":"16px","inputBorderStyle":"solid","tableHoverFontColor":"#333","inputBgColor":"rgba(36, 139, 146, 1)","pageStyle":true,"pageTotal":false,"btnAdAllAddFontColor":"rgba(36, 139, 146, 1)","tableBtnFont":"1","tableContentFontColor":"rgba(0, 1, 2, 1)","inputBorderColor":"rgba(220, 223, 230, 1)","tableShowHeader":true,"tableHoverBgColor":"rgba(142, 209, 214, 0.5)","tableBtnFontSize":"14px","tableBtnBorderColor":"rgba(220, 223, 230, 1)","inputIconPosition":"2","tableBorder":true,"btnAdAllBorderStyle":"solid","tableBtnBorderWidth":"3px","tableStripeBgColor":"#F5F7FA","tableBtnEditFontColor":"rgba(255, 255, 255, 1)","tableAlign":"center"},
      layouts: '',


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    gongzuojinshengCrossAddOrUpdate,
    renshidiaodongCrossAddOrUpdate,
    yuangongjixiaokaoheCrossAddOrUpdate,
    gongzuorenwuCrossAddOrUpdate,
  },
  methods: {
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    // rowStyle({ row, rowIndex}) {
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {color:this.contents.tableStripeFontColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    // cellStyle({ row, rowIndex}){
    //   if (rowIndex % 2 == 1) {
    //     if(this.contents.tableStripe) {
    //       return {backgroundColor:this.contents.tableStripeBgColor}
    //     }
    //   } else {
    //     return ''
    //   }
    // },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    gongzuojinshengCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.gongzuojinshengCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuangong');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.gongzuojinshengCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.gongzuojinshengCrossaddOrUpdate.init(row.id,type);
      });
    },
    renshidiaodongCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.renshidiaodongCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuangong');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.renshidiaodongCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.renshidiaodongCrossaddOrUpdate.init(row.id,type);
      });
    },
    yuangongjixiaokaoheCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.yuangongjixiaokaoheCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuangong');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.yuangongjixiaokaoheCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.yuangongjixiaokaoheCrossaddOrUpdate.init(row.id,type);
      });
    },
    gongzuorenwuCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.gongzuorenwuCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','yuangong');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.gongzuorenwuCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.gongzuorenwuCrossaddOrUpdate.init(row.id,type);
      });
    },
    chartDialog() {
      this.chartVisiable = !this.chartVisiable;
      this.$nextTick(()=>{
        //  renyuan
        // bumen bumen
        // xcolumn ycolumn bumen renyuan
        var renyuanChart = this.$echarts.init(document.getElementById("renyuanChart"),'macarons');
        this.$http({
            url: `yuangong/value/bumen/renyuan`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].bumen);
                    yAxis.push(parseFloat((res[i].total)).toFixed(2));
                    pArray.push({
                    value: parseFloat((res[i].total)),
                    name: res[i].bumen
                    })
                    var option = {};
                    option = {
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c}'
                        },
                        title: {
                            text: '员工',
                            left: 'center'
                        },
                        xAxis: {
                            type: 'category',
                            data: xAxis
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [{
                            data: yAxis,
                            type: 'bar'
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    renyuanChart.setOption(option);
                    //根据窗口的大小变动图表
                    window.onresize = function() {
                        renyuanChart.resize();
                    };
                }
            }
        });
      })
    },
    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
          if(this.searchForm.yuangonggonghao!='' && this.searchForm.yuangonggonghao!=undefined){
            params['yuangonggonghao'] = '%' + this.searchForm.yuangonggonghao + '%'
          }
          if(this.searchForm.yuangongxingming!='' && this.searchForm.yuangongxingming!=undefined){
            params['yuangongxingming'] = '%' + this.searchForm.yuangongxingming + '%'
          }
      this.$http({
        url: "yuangong/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yuangong/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
  .slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}
	
	& /deep/ .el-button--primary {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}
	
	& /deep/ .el-button--danger {
		height: 35px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 3px;
		border-style: solid;
		border-color: rgba(220, 223, 230, 1);
		border-radius: 10px 0px 10px 0px;
		background-color: rgba(36, 139, 146, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}
	
	.tables /deep/ .el-table__body tr {
				background-color: #f5f5f5 !important;
				color: rgba(0, 1, 2, 1) !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: #F5F7FA !important;
		color: rgba(0, 0, 0, 1) !important;
	}
	
	 .tables /deep/ .el-table__body tr:hover>td {
	   	   background-color: rgba(142, 209, 214, 0.5) !important;
	   	   	   color: #333 !important;
	   	 }
	 
</style>
