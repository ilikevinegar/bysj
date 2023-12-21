const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot14js1/",
            name: "springboot14js1",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "公司员工绩效管理系统"
        } 
    }
}
export default base
