// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: b.proto

package info.chenliang.b.message;

public final class B {
  private B() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Join_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Join_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_JoinResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_JoinResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Position_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Position_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MoveToPosition_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MoveToPosition_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Ping_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Ping_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Pong_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Pong_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageWrapper_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessageWrapper_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\007b.proto\"T\n\004Join\022\014\n\004room\030\001 \001(\005\022\014\n\004user\030" +
      "\002 \001(\t\022\017\n\007subPort\030\003 \001(\005\022\023\n\013subStreamId\030\004 " +
      "\001(\005\022\n\n\002ip\030\005 \001(\t\"\030\n\nJoinResult\022\n\n\002id\030\001 \001(" +
      "\005\" \n\010Position\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030\002 \001(\002\"-\n\016M" +
      "oveToPosition\022\033\n\010position\030\001 \001(\0132\t.Positi" +
      "on\"%\n\004Ping\022\014\n\004time\030\001 \001(\003\022\017\n\007message\030\002 \001(" +
      "\t\"%\n\004Pong\022\014\n\004time\030\001 \001(\003\022\017\n\007message\030\002 \001(\t" +
      "\"\242\001\n\016MessageWrapper\022\025\n\004join\030\001 \001(\0132\005.Join" +
      "H\000\022!\n\njoinResult\030\002 \001(\0132\013.JoinResultH\000\022!\n" +
      "\006action\030\003 \001(\0132\017.MoveToPositionH\000\022\025\n\004ping" +
      "\030\004 \001(\0132\005.PingH\000\022\025\n\004pong\030\005 \001(\0132\005.PongH\000B\005" +
      "\n\003msgB\034\n\030info.chenliang.b.messageP\001b\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Join_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Join_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Join_descriptor,
        new java.lang.String[] { "Room", "User", "SubPort", "SubStreamId", "Ip", });
    internal_static_JoinResult_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_JoinResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_JoinResult_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_Position_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Position_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Position_descriptor,
        new java.lang.String[] { "X", "Y", });
    internal_static_MoveToPosition_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_MoveToPosition_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MoveToPosition_descriptor,
        new java.lang.String[] { "Position", });
    internal_static_Ping_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Ping_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Ping_descriptor,
        new java.lang.String[] { "Time", "Message", });
    internal_static_Pong_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Pong_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Pong_descriptor,
        new java.lang.String[] { "Time", "Message", });
    internal_static_MessageWrapper_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_MessageWrapper_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessageWrapper_descriptor,
        new java.lang.String[] { "Join", "JoinResult", "Action", "Ping", "Pong", "Msg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
