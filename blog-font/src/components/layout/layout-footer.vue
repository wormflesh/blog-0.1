<template>
    <div id="layout-footer">
        <div class="footer-main">
            <div class="footer-item" >
                <div>

                </div>
            </div>
            <div class="footer-item">
                <div style="font-size:17px;font-weight: bold;">资源</div>
                <div><a target="_blank" class="out-link" href="https://leetcode-cn.com/">leetcode中文站</a></div>
                <div><a target="_blank" class="out-link" href="https://blog.nowcoder.net/wormflesh">WormFlesh的牛客博客</a></div>
                <div><a target="_blank" class="out-link" href="https://github.com/wormflesh">WormFlesh的githug主页</a></div>
            </div>
            <div class="footer-item">
                <div><a target="_blank" class="out-link" href="#">☞后台管理</a></div>
            </div>
        </div>
        <div class="copyright">Copyright © 2022 by <a target="_blank" class="out-link" href="https://www.wormflesh.top">wormflesh.top</a> . All rights reserved. | <a target="_blank" class="out-link" href="https://beian.miit.gov.cn">
冀ICP备2022005500号-1</a></div>
    </div>
</template>

<script>
    import sectionTitle from '@/components/section-title.vue'
    export default {
        name: "layout-footer",
        components:{
            sectionTitle
        },
    }
</script>

<style scoped lang="less">
#layout-footer{
    padding: 2%;
    border-top: 1px solid #F7F7F7;
    font-size: 13px;
    color: #9c9c9c;
    a.out-link:hover{
        color: #ff6d6d;
    }
    .footer-main{
        max-width: 800px;
        margin: 0 auto 20px auto;
        display: flex;
        justify-content: space-around;
        align-items: flex-start;
        .footer-item{
            flex: 1;
            & > div:not(:last-child){
                margin-bottom: 10px;
            }
            i{
                margin-right: 10px;
            }
        }
    }
    .copyright{
        text-align: center;
    }
}
    /*****/
    @media (max-width: 800px){
        #layout-footer{
            .footer-main .footer-item:nth-child(3){
                flex: 2;
            }
        }
    }
    @media (max-width: 600px){
        #layout-footer{
            .footer-main {
                display: block;
                .footer-item{
                    display: flex;
                    justify-content: space-around;
                    align-items: center;
                    flex-wrap: wrap;
                    & > div{
                        margin-bottom: 10px;
                    }
                }
            }
        }
    }
    /*****/
</style>