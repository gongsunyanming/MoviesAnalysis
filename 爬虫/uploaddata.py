from hdfs import InsecureClient

# 创建 HDFS 客户端
client = InsecureClient('http://192.168.79.131:50070', user='moqiling')

# 本地文件路径
local_file_path = './data.csv'

# HDFS 目标路径
hdfs_target_path = '/user/moqiling/data.csv'

# 上传文件到 HDFS
client.upload(hdfs_target_path, local_file_path)