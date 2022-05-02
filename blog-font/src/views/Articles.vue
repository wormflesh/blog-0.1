<template>
    <div class="articles">
        <banner isHome="true"></banner>
        <div class="site-content animate">
            <h2>{{blog.article_title}}</h2>
            <main class="site-main">
                <article class="hentry">
                    <!-- 文章头部 -->
                    <header class="entry-header">
                        <!-- 标题输出 -->
                        <h1 class="entry-title">{{blog.art_title}}</h1>
                        <hr>
                        <div class="breadcrumbs">
                            <div id="crumbs">最后更新时间：{{blog.art_date}}</div>
                        </div>
                    </header>

                    <!-- 正文输出 -->
                    <div class="entry-content">
                        <mavon-editor
                            class="md"
                            :value="blog.art_content"
                            :subfield="false"
                            :defaultOpen="'preview'"
                            :toolbarsFlag="false"
                            :editable="false"
                            :scrollStyle="true"
                            :ishljs="true"
                        />
                    </div>

                    <!-- 文章底部 -->
                    <section-title>
                        <footer class="post-footer">
                            <!-- 阅读次数 -->
                            <div class="post-like">
                                <i class="iconfont iconeyes"></i>
                                <span class="count">{{blog.art_views}}</span>
                            </div>
                            <!-- 分享按钮 -->
                            <!-- <div class="post-share">
                                <ul class="sharehidden">
                                    <li><a href="http://qr.liantu.com/api.php?text=https://zhebk.cn/Web/gongan.html"
                                            onclick="window.open(this.href, 'renren-share', 'width=490,height=700');return false;"
                                            class="s-weixin" target="_blank" rel="nofollow noopener noreferrer"><img src="https://cdn.zhebk.cn/usr/themes/Akina/images/wechat.png"></a></li>
                                    <li>
                                        <a href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=https://zhebk.cn/Web/gongan.html/&amp;title=公安联网备案记录"
                                            onclick="window.open(this.href, 'weibo-share', 'width=730,height=500');return false;"
                                            class="s-qq" target="_blank" rel="nofollow noopener noreferrer"><img src="https://cdn.zhebk.cn/usr/themes/Akina/images/qzone.png"></a></li>
                                    <li>
                                        <a href="http://service.weibo.com/share/share.php?url=https://zhebk.cn/Web/gongan.html/&amp;title=公安联网备案记录"
                                            onclick="window.open(this.href, 'weibo-share', 'width=550,height=235');return false;"
                                            class="s-sina" target="_blank" rel="nofollow noopener noreferrer"><img src="https://cdn.zhebk.cn/usr/themes/Akina/images/sina.png"></a></li>
                                    <li>
                                        <a href="http://shuo.douban.com/!service/share?https://zhebk.cn/Web/gongan.html/&amp;title=公安联网备案记录"
                                            onclick="window.open(this.href, 'renren-share', 'width=490,height=600');return false;"
                                            class="s-douban" target="_blank" rel="nofollow noopener noreferrer"><img src="https://cdn.zhebk.cn/usr/themes/Akina/images/douban.png"></a></li>
                                </ul>
                                <i class="iconfont show-share"></i>
                            </div> -->

                            <!-- 文章标签 -->
                            <div class="post-tags">
                                <i class="iconfont iconcategory"></i>
                                <template v-for="tag in tags">
                                    <router-link :to="'/category/'+tag.label_name" :key="tag.label_id"> {{tag.label_name}} </router-link>
                                    
                                </template>
                            </div>
                        </footer>
                    </section-title>
                </article>
            </main>
        </div>
    </div>
</template>

<script>
    import Banner from '@/components/banner'
    import sectionTitle from '@/components/section-title'
    import {fetchArticle} from '../api'
    export default {
        name: 'Article',
        data() {
            return {
                blog: [],
                tags: []
            }
        },
        components: {
            Banner,
            sectionTitle
        },
        methods: {
          getArticle(){
              fetchArticle(this.$route.params.id).then(res => {
                  this.blog = res.data.data.article || []
                  this.tags = res.data.data.labels || []
                  console.log(this.blog);
              }).catch(err => {
                  console.log(err)
              })
          },
        },
        created() {
            this.getArticle()
        }
    }
</script>
<style scoped lang="less">
    .site-content {
        position: relative;
        .site-main {
            padding: 80px 0 0 0;
        }
    }
    #article-menus{
        position: sticky;
        top: 0;
        box-shadow: 0 2px 6px rgba(0, 0, 0, .1);
        border-radius: 3px;
        padding: 15px;
        width: 300px;
        transform: translateX(-120%) translateY(150px);
        font-size: 14px;
    }
    article.hentry {
        .entry-header {
            .entry-title {
                font-size: 23px;
                font-weight: 600;
                color: #737373;
                margin: 0.67em 0;

                &:before {
                    content: "#";
                    margin-right: 6px;
                    color: #d82e16;
                    font-size: 20px;
                    font-weight: 600;
                }
            }

            hr {
                height: 1px;
                border: 0;
                background: #EFEFEF;
                margin: 15px 0;
            }

            .breadcrumbs {
                font-size: 14px;
                color: #D2D2D2;
                text-decoration: none;
                margin-bottom: 30px;
            }
        }

        footer.post-footer {
            width: 100%;
            padding: 20px 10px;
            margin-top: 30px;
            height: 65px;
            position: relative;
            i{
                font-size: 18px;
                margin-right: 5px;
            }
            .post-like {
                float: right;
                margin: 7px 0 0 20px;
            }

            .post-share {
                float: right;
                list-style: none;
                margin-right: 20px;
            }

            .donate {
                float: left;
                line-height: 36px;
                border-radius: 100%;
                -webkit-border-radius: 100%;
                -moz-border-radius: 100%;
                border: 1px solid #2B2B2B;
                &:hover{
                    border: 1px solid goldenrod;
                    span{
                        color: goldenrod;
                    }
                }
                span {
                    color: #2B2B2B;
                    padding: 10px;
                    position: relative;
                    cursor: pointer;
                }

                .donate_inner {
                    display: none;
                    margin: 0;
                    list-style: none;
                    position: absolute;
                    left: 80px;
                    top: -40px;
                    background: #FFF;
                    padding: 10px;
                    border: 1px solid #ddd;
                    box-shadow: 0 2px 6px rgba(0, 0, 0, .08);
                    border-radius: 3px;
                    &.show{
                        display: block;
                    }
                    li {
                        float: left;
                    }

                    img {
                        width: 100px;
                    }
                    p {
                        text-align: center;
                        font-size: 15px;
                        color: #D2D2D2;
                        line-height: 1rem;
                    }
                }

                .donate_inner:after, .donate_inner:before {
                    content: "";
                    position: absolute;
                    left: 0;
                    bottom: 45%;
                    margin-left: -8px;
                    border-top: 8px solid transparent;
                    border-bottom: 8px solid transparent;
                    border-right: 8px solid #fff;
                }

                .donate_inner:before {
                    left: -1px;
                    border-right: 8px solid #ddd;
                }

            }

            .post-tags {
                margin: 7px 0 0 20px;
                float: left;
                text-transform: uppercase;
                a:hover{
                    color: #ff6d6d;
                }
            }
        }
        .open-message {
            margin: 50px 0;
            position: relative;
            background: #2B2B2B;
            padding: 10px 30px;
            border-radius: 3px;
            font-size: 14px;
            color: #fff;
            &:after {
                content: "";
                border-left: 10px solid transparent;
                border-right: 10px solid transparent;
                border-bottom: 10px solid #2B2B2B;
                position: absolute;
                top: -8px;
                left: 48%;
            }
            p {
                margin: 10px 0;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
            }
            a {
                color: #A0DAD0;
                padding: 0 5px;
            }
        }
    }
.router-link-active {
  text-decoration: none;
  color: #4d1018;
}
a {
  text-decoration: none;
  color: #4d1018;
}
</style>
