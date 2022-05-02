<template>
    <div class="feature">
        <router-link :to="`/article/${data.art_id}`">
            <div class="feature-title"><span class="foverlay">{{data.art_title}}</span></div>
            <img :src="data.art_image">
        </router-link>
    </div>
</template>

<script>
    export default {
        name: "feature",
        props: {
            data: {
                type: Object,
                default: () =>{
                    return{
                        title: 'Akina',
                        img: 'https://w.wallhaven.cc/full/v9/wallhaven-v9v3r5.jpg',
                        href: 'https://zhebk.cn/Web/Akina.html'
                    }
                }
            }
        }
    }
</script>

<style scoped lang="less">
    .feature {
        width: inherit;
        position: relative;
        img {
            height: 160px;
            width: 257px;
            object-fit: cover;
            border-radius: 5px;
        }
        & a:hover .foverlay{
            opacity:1;
        }
        .foverlay {
            position: absolute;
            z-index: 2;
            width: 257px;
            height: 160px;
            text-align: center;
            line-height: 160px;
            background: #BBE2DB;
            color: white;
            font-size: 16px;
            opacity: 0;
            border-radius: 5px;

            -moz-transition: opacity .4s ease-out;
            -o-transition: opacity .4s ease-out;
            -webkit-transition: opacity .4s ease-out;
            transition: opacity .4s ease-out;
        }
    }
</style>