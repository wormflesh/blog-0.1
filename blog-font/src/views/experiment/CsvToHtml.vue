<template>
    <div class="experiment">
        <div class="site-content">
            <div class="upload-content">
                <el-upload
                    class="upload"
                    drag
                    action="file"
                    :http-request="submit"
                    multiple>
                    <i class="el-icon-upload"></i>
                    <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    <div class="el-upload__tip" slot="tip">只能上传csv文件(暂时只支持GBK编码文件)</div>
                </el-upload>
                <!--文件上传表单-->
                <!-- <form class="upload_page">
                    <input type="file" @change="getFile($event)">
                    <el-button type="primary" @click="submit($event)">上传<i class="el-icon-upload el-icon--right"></i></el-button>
                </form> -->
            </div>
            <div class="html-content">
                <quote>以下为HTML页面</quote>
                <div class="iframe_page">
                    <iframe :src=htmlUrl name="ifd" onload="this.height=ifd.document.body.scrollHeight" width="100%" scrolling="no" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {csvToHtml} from '@/api'
import Quote from '@/components/quote'
export default {
    name: 'csvToHtml',
    data () {
        return{
            //文件
            file: '',
            htmlUrl: '',
        }
    },
    components: {
        Quote,
    },
    methods: {
        submit(val) {    
            const _this = this
            //创建 formData 对象
            let formData = new FormData();
            // 向 formData 对象中添加文件
            formData.append('file',val.file);
            axios.post('https://wormflesh.top:8882/api/experiment/csvToHtml', formData).then(function (resp) {
                _this.htmlUrl = resp.data.data
            })
        },
        // submit(event) {
        //     const _this = this
        //     event.preventDefault();//取消默认行为
        //     //创建 formData 对象
        //     let formData = new FormData();
        //     // 向 formData 对象中添加文件
        //     formData.append('file',this.file);
        //     axios.post('https://wormflesh.top:8882/api/experiment/csvToHtml', formData).then(function (resp) {
        //         _this.htmlUrl = resp.data.data
        //         console.log("success");
        //     })
        // },
        getFile(event) {
            this.file = event.target.files[0];
            console.log(this.file);
        },
    },
}
</script>

<style lang="less" scoped>
.site-content {
    position: relative;
    margin-top: 80px;
    
}
.upload-content {
    margin-top: 10px;
    text-align:center;
}
.html-content {
    margin-left: 0px;
    margin-top: 30px;
    margin-right: 0px;
    margin-bottom: 0px;
    background-color: #7a7374;
    .iframe_page {
        margin-top: 10px;
        margin-bottom: 20px;
        height: 650px;
        overflow: hidden;
    }
}
</style>