// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: b.proto

package info.chenliang.b.message;

/**
 * Protobuf type {@code MoveToPosition}
 */
public  final class MoveToPosition extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:MoveToPosition)
    MoveToPositionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MoveToPosition.newBuilder() to construct.
  private MoveToPosition(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MoveToPosition() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MoveToPosition(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            info.chenliang.b.message.Position.Builder subBuilder = null;
            if (position_ != null) {
              subBuilder = position_.toBuilder();
            }
            position_ = input.readMessage(info.chenliang.b.message.Position.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(position_);
              position_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return info.chenliang.b.message.B.internal_static_MoveToPosition_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return info.chenliang.b.message.B.internal_static_MoveToPosition_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            info.chenliang.b.message.MoveToPosition.class, info.chenliang.b.message.MoveToPosition.Builder.class);
  }

  public static final int POSITION_FIELD_NUMBER = 1;
  private info.chenliang.b.message.Position position_;
  /**
   * <code>.Position position = 1;</code>
   */
  public boolean hasPosition() {
    return position_ != null;
  }
  /**
   * <code>.Position position = 1;</code>
   */
  public info.chenliang.b.message.Position getPosition() {
    return position_ == null ? info.chenliang.b.message.Position.getDefaultInstance() : position_;
  }
  /**
   * <code>.Position position = 1;</code>
   */
  public info.chenliang.b.message.PositionOrBuilder getPositionOrBuilder() {
    return getPosition();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (position_ != null) {
      output.writeMessage(1, getPosition());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (position_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPosition());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof info.chenliang.b.message.MoveToPosition)) {
      return super.equals(obj);
    }
    info.chenliang.b.message.MoveToPosition other = (info.chenliang.b.message.MoveToPosition) obj;

    boolean result = true;
    result = result && (hasPosition() == other.hasPosition());
    if (hasPosition()) {
      result = result && getPosition()
          .equals(other.getPosition());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPosition()) {
      hash = (37 * hash) + POSITION_FIELD_NUMBER;
      hash = (53 * hash) + getPosition().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static info.chenliang.b.message.MoveToPosition parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.chenliang.b.message.MoveToPosition parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static info.chenliang.b.message.MoveToPosition parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static info.chenliang.b.message.MoveToPosition parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(info.chenliang.b.message.MoveToPosition prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code MoveToPosition}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:MoveToPosition)
      info.chenliang.b.message.MoveToPositionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return info.chenliang.b.message.B.internal_static_MoveToPosition_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return info.chenliang.b.message.B.internal_static_MoveToPosition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              info.chenliang.b.message.MoveToPosition.class, info.chenliang.b.message.MoveToPosition.Builder.class);
    }

    // Construct using info.chenliang.b.message.MoveToPosition.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (positionBuilder_ == null) {
        position_ = null;
      } else {
        position_ = null;
        positionBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return info.chenliang.b.message.B.internal_static_MoveToPosition_descriptor;
    }

    @java.lang.Override
    public info.chenliang.b.message.MoveToPosition getDefaultInstanceForType() {
      return info.chenliang.b.message.MoveToPosition.getDefaultInstance();
    }

    @java.lang.Override
    public info.chenliang.b.message.MoveToPosition build() {
      info.chenliang.b.message.MoveToPosition result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public info.chenliang.b.message.MoveToPosition buildPartial() {
      info.chenliang.b.message.MoveToPosition result = new info.chenliang.b.message.MoveToPosition(this);
      if (positionBuilder_ == null) {
        result.position_ = position_;
      } else {
        result.position_ = positionBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof info.chenliang.b.message.MoveToPosition) {
        return mergeFrom((info.chenliang.b.message.MoveToPosition)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(info.chenliang.b.message.MoveToPosition other) {
      if (other == info.chenliang.b.message.MoveToPosition.getDefaultInstance()) return this;
      if (other.hasPosition()) {
        mergePosition(other.getPosition());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      info.chenliang.b.message.MoveToPosition parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (info.chenliang.b.message.MoveToPosition) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private info.chenliang.b.message.Position position_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        info.chenliang.b.message.Position, info.chenliang.b.message.Position.Builder, info.chenliang.b.message.PositionOrBuilder> positionBuilder_;
    /**
     * <code>.Position position = 1;</code>
     */
    public boolean hasPosition() {
      return positionBuilder_ != null || position_ != null;
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public info.chenliang.b.message.Position getPosition() {
      if (positionBuilder_ == null) {
        return position_ == null ? info.chenliang.b.message.Position.getDefaultInstance() : position_;
      } else {
        return positionBuilder_.getMessage();
      }
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public Builder setPosition(info.chenliang.b.message.Position value) {
      if (positionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        position_ = value;
        onChanged();
      } else {
        positionBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public Builder setPosition(
        info.chenliang.b.message.Position.Builder builderForValue) {
      if (positionBuilder_ == null) {
        position_ = builderForValue.build();
        onChanged();
      } else {
        positionBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public Builder mergePosition(info.chenliang.b.message.Position value) {
      if (positionBuilder_ == null) {
        if (position_ != null) {
          position_ =
            info.chenliang.b.message.Position.newBuilder(position_).mergeFrom(value).buildPartial();
        } else {
          position_ = value;
        }
        onChanged();
      } else {
        positionBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public Builder clearPosition() {
      if (positionBuilder_ == null) {
        position_ = null;
        onChanged();
      } else {
        position_ = null;
        positionBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public info.chenliang.b.message.Position.Builder getPositionBuilder() {
      
      onChanged();
      return getPositionFieldBuilder().getBuilder();
    }
    /**
     * <code>.Position position = 1;</code>
     */
    public info.chenliang.b.message.PositionOrBuilder getPositionOrBuilder() {
      if (positionBuilder_ != null) {
        return positionBuilder_.getMessageOrBuilder();
      } else {
        return position_ == null ?
            info.chenliang.b.message.Position.getDefaultInstance() : position_;
      }
    }
    /**
     * <code>.Position position = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        info.chenliang.b.message.Position, info.chenliang.b.message.Position.Builder, info.chenliang.b.message.PositionOrBuilder> 
        getPositionFieldBuilder() {
      if (positionBuilder_ == null) {
        positionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            info.chenliang.b.message.Position, info.chenliang.b.message.Position.Builder, info.chenliang.b.message.PositionOrBuilder>(
                getPosition(),
                getParentForChildren(),
                isClean());
        position_ = null;
      }
      return positionBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:MoveToPosition)
  }

  // @@protoc_insertion_point(class_scope:MoveToPosition)
  private static final info.chenliang.b.message.MoveToPosition DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new info.chenliang.b.message.MoveToPosition();
  }

  public static info.chenliang.b.message.MoveToPosition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MoveToPosition>
      PARSER = new com.google.protobuf.AbstractParser<MoveToPosition>() {
    @java.lang.Override
    public MoveToPosition parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MoveToPosition(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MoveToPosition> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MoveToPosition> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public info.chenliang.b.message.MoveToPosition getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

