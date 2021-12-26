生产者推送消息的消息确认
推送消息存在四种情况：
①消息推送到server，但是在server里找不到交换机
  结论：这种情况触发的是 ConfirmCallback 回调函数
②消息推送到server，找到交换机了，但是没找到队列
  结论：这种情况触发的是 ConfirmCallback和RetrunCallback两个回调函数
③消息推送到sever，交换机和队列啥都没找到
  结论： 这种情况触发的是 ConfirmCallback 回调函数
④消息推送成功
  结论： 这种情况触发的是 ConfirmCallback 回调函数