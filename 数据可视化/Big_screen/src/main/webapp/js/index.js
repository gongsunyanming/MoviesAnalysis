$(function () {
    echart_1();
    echart_2();
    echart_3();
    echart_4();
    echart_5();
    echart_6();
    echart_7();

    function echart_1() {
        $.get("http://localhost:8080/getPart1", function (res) {
            var myChart = echarts.init(document.getElementById('echart_1'));
            var xAxisData = res.key;
            var seriesData = res.val.map(Number);
            var option = {
                xAxis: {
                    type: 'category',
                    axisLabel: {
                        interval: 0, // 设置轴标签全部显示
                        rotate: 30 // 适当旋转标签以避免重叠
                    },
                    data: xAxisData
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: seriesData,
                    type: 'bar'
                }]
            };
            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：不同年份上映电影数", error);
        });
    }

    function echart_2() {
        $.get("http://localhost:8080/getPart2", function (data) {
            // 整理数据
            const countMap = {};
            data.val.forEach((count, index) => {
                const numCount = Number(count);
                if (!countMap[numCount]) {
                    countMap[numCount] = 0;
                }
                countMap[numCount]++;
            });

            // 构建图表数据
            const barData = [];
            for (const count in countMap) {
                barData.push({
                    name: `出现次数 ${count}`,
                    data: [countMap[count]]
                });
            }

            // 初始化图表
            const myChart = echarts.init(document.getElementById('echart_2'));

            const option = {
                title: {
                    text: '根据演员出现次数统计人数'
                },
                xAxis: {
                    type: 'category',
                    data: barData.map(item => item.name)
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    type: 'bar',
                    data: barData.map(item => item.data)
                }]
            };

            myChart.setOption(option);
        });
    }

    function echart_3() {
        $.get("http://localhost:8080/getPart3", function (res) {
            var myChart = echarts.init(document.getElementById('echart_3'));
            var totalValue = res.val.reduce((acc, val) => acc + val, 0);
            var dataWithPercentage = res.val.map((item, index) => ({
                name: res.key[index],
                value: item,
                itemStyle: {
                    color: getRandomColor_echart_5()
                },
                percentage: ((item / totalValue) * 100).toFixed(2) + '%'
            }));
            var option = {
                series: [{
                    type: 'pie',
                    data: dataWithPercentage,
                    label: {
                        formatter: '{b}: {c} ({d})'
                    }
                }]
            };
            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：电影类型分析", error);
        });
    }

    function echart_4() {
        $.get("http://localhost:8080/getPart4", function (res) {
            var myChart = echarts.init(document.getElementById('echart_4'));
            var xAxisData = res.key;
            var seriesData = res.val.map(Number);
            var option = {
                xAxis: {
                    type: 'category',
                    axisLabel: {
                        interval: 0, // 设置轴标签全部显示
                        rotate: 30 // 适当旋转标签以避免重叠
                    },
                    data: xAxisData
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: seriesData,
                    type: 'bar'
                }]
            };
            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：电影类型平均评分", error);
        });
    }

    function echart_5() {
        $.get("http://localhost:8080/getPart5", function (res) {
            // 1. 数据预处理：按照评分范围分组
            const groupedData = {
                lowScore: [],
                mediumScore: [],
                highScore: []
            };
            res.key.forEach((item, index) => {
                const score = Number(res.val[index]);
                if (score <= 5) {
                    groupedData.lowScore.push(item);
                } else if (score <= 8) {
                    groupedData.mediumScore.push(item);
                } else {
                    groupedData.highScore.push(item);
                }
            });

            // 计算每个区间的占比
            const totalActors = res.key.length;
            const lowScorePercentage = (groupedData.lowScore.length / totalActors) * 100;
            const mediumScorePercentage = (groupedData.mediumScore.length / totalActors) * 100;
            const highScorePercentage = (groupedData.highScore.length / totalActors) * 100;

            // 2. 创建图表
            var myChart = echarts.init(document.getElementById('echart_5'));
            const data = [
                {
                    value: groupedData.lowScore.length,
                    name: '低分区间（占比：' + lowScorePercentage.toFixed(2) + '%）',
                    itemStyle: {
                        color: getRandomColor_echart_5()
                    }
                },
                {
                    value: groupedData.mediumScore.length,
                    name: '中等分数区间（占比：' + mediumScorePercentage.toFixed(2) + '%）',
                    itemStyle: {
                        color: getRandomColor_echart_5()
                    }
                },
                {
                    value: groupedData.highScore.length,
                    name: '高分区间（占比：' + highScorePercentage.toFixed(2) + '%）',
                    itemStyle: {
                        color: getRandomColor_echart_5()
                    }
                }
            ];
            const option = {
                title: {
                    text: '根据演员平均评分进行区间划分',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: '演员评分区间分布',
                        type: 'pie',
                        radius: '50%',
                        data: data,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            // 3. 添加交互事件
            myChart.on('click', function (params) {
                if (params.componentType === 'series') {
                    const selectedRange = params.name;
                    let actorsForRange;
                    if (selectedRange === '低分区间（占比：' + lowScorePercentage.toFixed(2) + '%）') {
                        actorsForRange = groupedData.lowScore;
                    } else if (selectedRange === '中等分数区间（占比：' + mediumScorePercentage.toFixed(2) + '%）') {
                        actorsForRange = groupedData.mediumScore;
                    } else {
                        actorsForRange = groupedData.highScore;
                    }
                    showDetailedActors(actorsForRange);
                }
            });

            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：演员平均评分", error);
        });
    }

    function getRandomColor_echart_5() {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    function showDetailedActors(actors) {
        // 这里可以根据需要实现展示详细演员信息的逻辑
        console.log(actors);
    }

    function echart_6() {
        $.get("http://localhost:8080/getPart6", function (res) {
            var myChart = echarts.init(document.getElementById('echart_6'));
            var option = {
                xAxis: {
                    type: 'category',
                    axisLabel: {
                        interval: 0, // 设置轴标签全部显示
                        rotate: 30 // 适当旋转标签以避免重叠
                    },
                    data: res.key
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: res.val.map(Number),
                    type: 'line'
                }]
            };
            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：不同年份电影平均评分", error);
        });
    }

    function echart_7() {
        $.get("http://localhost:8080/getPart7", function (res) {
            var myChart = echarts.init(document.getElementById('echart_7'));
            var option = {
                xAxis: {
                    type: 'category',
                    axisLabel: {
                        interval: 0, // 设置轴标签全部显示
                        rotate: 30 // 适当旋转标签以避免重叠
                    },
                    data: res.key
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: res.val.map(Number),
                    type: 'bar'
                }]
            };
            myChart.setOption(option);
        }).fail(function (error) {
            console.error("数据获取失败：不同评分出现次数", error);
        });
    }
});