import pandas as pd
import ast

# 创建空的DF
df = pd.DataFrame(columns=['id', '标题', '评分', '上映日期', '海报', '主演', '地区', '电影类型', '评论人数'])

# 打开ur.txt文件
with open('ur.txt', 'r', encoding='utf-8') as f:
    lines = f.readlines()
    for line in lines:
        # 数据提取
        data = ast.literal_eval(line.strip())[0]  # 转换为字典形式
        movie_id = data['id']  # 电影id
        title = data['title']  # 电影标题
        score = data['rating'][0]  # 电影评分
        date = data['release_date']  # 上映日期
        poster = data['cover_url']  # 海报
        actors = ', '.join(data['actors'])  # 主演
        regions = ', '.join(data['regions'])  # 地区
        types = ', '.join(data['types'])  # 电影类型
        vote_count = data['vote_count']  # 评论人数
        # 提取出来的数据写入df里
        df = df.append({'id': movie_id, '标题': title,'评分': score, '上映日期': date, '海报': poster,
                        '主演': actors, '地区': regions, '电影类型': types, '评论人数': vote_count},
                       ignore_index=True)

# 保存为csv文件
df.to_csv('data.csv',encoding='utf-8', index=False)
# df.to_csv('test.csv',encoding='utf-8', index=False)


# 上传至HDFS进行存储
