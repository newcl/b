// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: b.proto

package info.chenliang.b.message;

public interface MessageWrapperOrBuilder extends
    // @@protoc_insertion_point(interface_extends:MessageWrapper)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Join join = 1;</code>
   */
  boolean hasJoin();
  /**
   * <code>.Join join = 1;</code>
   */
  info.chenliang.b.message.Join getJoin();
  /**
   * <code>.Join join = 1;</code>
   */
  info.chenliang.b.message.JoinOrBuilder getJoinOrBuilder();

  /**
   * <code>.JoinResult joinResult = 2;</code>
   */
  boolean hasJoinResult();
  /**
   * <code>.JoinResult joinResult = 2;</code>
   */
  info.chenliang.b.message.JoinResult getJoinResult();
  /**
   * <code>.JoinResult joinResult = 2;</code>
   */
  info.chenliang.b.message.JoinResultOrBuilder getJoinResultOrBuilder();

  /**
   * <code>.MoveToPosition action = 3;</code>
   */
  boolean hasAction();
  /**
   * <code>.MoveToPosition action = 3;</code>
   */
  info.chenliang.b.message.MoveToPosition getAction();
  /**
   * <code>.MoveToPosition action = 3;</code>
   */
  info.chenliang.b.message.MoveToPositionOrBuilder getActionOrBuilder();

  /**
   * <code>.Ping ping = 4;</code>
   */
  boolean hasPing();
  /**
   * <code>.Ping ping = 4;</code>
   */
  info.chenliang.b.message.Ping getPing();
  /**
   * <code>.Ping ping = 4;</code>
   */
  info.chenliang.b.message.PingOrBuilder getPingOrBuilder();

  /**
   * <code>.Pong pong = 5;</code>
   */
  boolean hasPong();
  /**
   * <code>.Pong pong = 5;</code>
   */
  info.chenliang.b.message.Pong getPong();
  /**
   * <code>.Pong pong = 5;</code>
   */
  info.chenliang.b.message.PongOrBuilder getPongOrBuilder();

  public info.chenliang.b.message.MessageWrapper.MsgCase getMsgCase();
}
