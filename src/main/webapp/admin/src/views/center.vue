<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='bumenlingdao'"  label="领导账号" prop="lingdaozhanghao">
          <el-input v-model="ruleForm.lingdaozhanghao" readonly              placeholder="领导账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='bumenlingdao'"  label="领导姓名" prop="lingdaoxingming">
          <el-input v-model="ruleForm.lingdaoxingming"               placeholder="领导姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='bumenlingdao'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in bumenlingdaoxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='bumenlingdao'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="bumenlingdaozhaopianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='bumenlingdao'"  label="部门" prop="bumen">
          <el-select v-model="ruleForm.bumen" :disabled="true" placeholder="请选择部门">
            <el-option
                v-for="(item,index) in bumenlingdaobumenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='bumenlingdao'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="员工工号" prop="yuangonggonghao">
          <el-input v-model="ruleForm.yuangonggonghao" readonly              placeholder="员工工号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="员工姓名" prop="yuangongxingming">
          <el-input v-model="ruleForm.yuangongxingming"               placeholder="员工姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='yuangong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yuangongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='yuangong'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yuangongtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="人员" prop="renyuan">
          <el-input v-model="ruleForm.renyuan" readonly              placeholder="人员" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='yuangong'"  label="职位" prop="zhiwei">
          <el-select v-model="ruleForm.zhiwei"  placeholder="请选择职位">
            <el-option
                v-for="(item,index) in yuangongzhiweiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="地址" prop="dizhi">
          <el-input v-model="ruleForm.dizhi"               placeholder="地址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="教育经历" prop="jiaoyujingli">
          <el-input v-model="ruleForm.jiaoyujingli"               placeholder="教育经历" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="工作经历" prop="gongzuojingli">
          <el-input v-model="ruleForm.gongzuojingli"               placeholder="工作经历" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="家庭背景" prop="jiatingbeijing">
          <el-input v-model="ruleForm.jiatingbeijing"               placeholder="家庭背景" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="培训经历" prop="peixunjingli">
          <el-input v-model="ruleForm.peixunjingli"               placeholder="培训经历" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="语言能力" prop="yuyannengli">
          <el-input v-model="ruleForm.yuyannengli"               placeholder="语言能力" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="个人职称" prop="gerenzhicheng">
          <el-input v-model="ruleForm.gerenzhicheng"               placeholder="个人职称" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="领导账号" prop="lingdaozhanghao">
          <el-input v-model="ruleForm.lingdaozhanghao" readonly              placeholder="领导账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="领导姓名" prop="lingdaoxingming">
          <el-input v-model="ruleForm.lingdaoxingming" readonly              placeholder="领导姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yuangong'"  label="部门" prop="bumen">
          <el-input v-model="ruleForm.bumen" readonly              placeholder="部门" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      bumenlingdaoxingbieOptions: [],
      bumenlingdaobumenOptions: [],
      yuangongxingbieOptions: [],
      yuangongzhiweiOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.bumenlingdaoxingbieOptions = "男,女".split(',')
    this.$http({
      url: `option/bumen/bumen`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.bumenlingdaobumenOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yuangongxingbieOptions = "男,女".split(',')
    this.$http({
      url: `option/zhiwei/zhiwei`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.yuangongzhiweiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    bumenlingdaozhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
    yuangongtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.lingdaozhanghao)&& 'bumenlingdao'==this.flag){
        this.$message.error('领导账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'bumenlingdao'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.lingdaoxingming)&& 'bumenlingdao'==this.flag){
        this.$message.error('领导姓名不能为空');
        return
      }
        if(this.ruleForm.zhaopian!=null) {
                this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.bumen)&& 'bumenlingdao'==this.flag){
        this.$message.error('部门不能为空');
        return
      }
      if( 'bumenlingdao' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if((!this.ruleForm.yuangonggonghao)&& 'yuangong'==this.flag){
        this.$message.error('员工工号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yuangong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.yuangongxingming)&& 'yuangong'==this.flag){
        this.$message.error('员工姓名不能为空');
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'yuangong' ==this.flag && this.ruleForm.renyuan&&(!isIntNumer(this.ruleForm.renyuan))){
       this.$message.error(`人员应输入整数`);
        return
      }
      if((!this.ruleForm.zhiwei)&& 'yuangong'==this.flag){
        this.$message.error('职位不能为空');
        return
      }
      if( 'yuangong' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
