import request from '@/utils/request'

// 获取文章---分页
export function fetchPage(current) {
    return request({
        url: '/article/getArticlesByPage/'+current+'/8',
        method: 'get',
    })
}

// 获取分类文章---分页
export function fetchPageByCategory(cate, current) {
    return request({
        url: 'article/getArticleByCategory/'+cate+'/'+current+'/8',
        method: 'get',
    })
}

// 获取标签文章---分页
export function fetchPageByLabel(label, current) {
    return request({
        url: 'article/getArticleByLabel/'+label+'/'+current+'/8',
        method: 'get',
    })
}

// 获取搜索文章---分页
export function fetchPageByWords(words, current) {
    return request({
        url: 'article/getArticleByTitle/'+words+'/'+current+'/8',
        method: 'get',
    })
}

// 获取分类列表
export function fetchCategory() {
    return request({
        url: '/category/getCategorys',
        method: 'get',
    })
}

// 获取焦点内容
export function fetchFeature() {
    return request({
        url: '/article/getFeatureArticle',
        method: 'get',
    })
}

// 获取文章
export function fetchArticle(id) {
    return request({
        url: '/article/getArticleById/'+id,
        method: 'get',
    })
}
// --------------------------实验-----------------------------------
// 获取文章
export function csvToHtml() {
    return request({
        url: '/experiment/csvToHtml/',
        method: 'post',
    })
}