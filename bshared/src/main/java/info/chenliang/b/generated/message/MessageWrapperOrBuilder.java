// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: b.proto

package info.chenliang.b.generated.message;

public interface MessageWrapperOrBuilder extends
    // @@protoc_insertion_point(interface_extends:MessageWrapper)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Handshake handshake = 1;</code>
   */
  boolean hasHandshake();
  /**
   * <code>.Handshake handshake = 1;</code>
   */
  info.chenliang.b.generated.message.Handshake getHandshake();
  /**
   * <code>.Handshake handshake = 1;</code>
   */
  info.chenliang.b.generated.message.HandshakeOrBuilder getHandshakeOrBuilder();

  /**
   * <code>.MoveToPosition action = 2;</code>
   */
  boolean hasAction();
  /**
   * <code>.MoveToPosition action = 2;</code>
   */
  info.chenliang.b.generated.message.MoveToPosition getAction();
  /**
   * <code>.MoveToPosition action = 2;</code>
   */
  info.chenliang.b.generated.message.MoveToPositionOrBuilder getActionOrBuilder();

  /**
   * <code>.Ping ping = 3;</code>
   */
  boolean hasPing();
  /**
   * <code>.Ping ping = 3;</code>
   */
  info.chenliang.b.generated.message.Ping getPing();
  /**
   * <code>.Ping ping = 3;</code>
   */
  info.chenliang.b.generated.message.PingOrBuilder getPingOrBuilder();

  /**
   * <code>.Pong pong = 4;</code>
   */
  boolean hasPong();
  /**
   * <code>.Pong pong = 4;</code>
   */
  info.chenliang.b.generated.message.Pong getPong();
  /**
   * <code>.Pong pong = 4;</code>
   */
  info.chenliang.b.generated.message.PongOrBuilder getPongOrBuilder();

  public info.chenliang.b.generated.message.MessageWrapper.MsgCase getMsgCase();
}
