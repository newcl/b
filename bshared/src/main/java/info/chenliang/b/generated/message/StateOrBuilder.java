// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: b.proto

package info.chenliang.b.generated.message;

public interface StateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:State)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>.Position position = 2;</code>
   */
  boolean hasPosition();
  /**
   * <code>.Position position = 2;</code>
   */
  info.chenliang.b.generated.message.Position getPosition();
  /**
   * <code>.Position position = 2;</code>
   */
  info.chenliang.b.generated.message.PositionOrBuilder getPositionOrBuilder();

  /**
   * <code>.Speed speed = 3;</code>
   */
  boolean hasSpeed();
  /**
   * <code>.Speed speed = 3;</code>
   */
  info.chenliang.b.generated.message.Speed getSpeed();
  /**
   * <code>.Speed speed = 3;</code>
   */
  info.chenliang.b.generated.message.SpeedOrBuilder getSpeedOrBuilder();
}
